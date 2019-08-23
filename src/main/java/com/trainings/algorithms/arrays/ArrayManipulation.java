package com.trainings.algorithms.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each
 * operation add a value to each of the array element between two given indices,
 * inclusive. Once all operations have been performed, return the maximum value
 * in your array.
 * 
 * @author thiago
 *
 */

class Interval {
	private Integer start;
	private Integer end;
	private Integer maxValue;

	public Interval(int start, int end, int maxValue) {
		super();
		this.start = start;
		this.end = end;
		this.maxValue = maxValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "start=" + start + ", end=" + end + ", maxValue=" + maxValue;
	}

}

public class ArrayManipulation {
	private static final int VALUE_TO_ADD = 2;
	private static final int END = 1;
	private static final int START = 0;

	public static long arrayManipulationInitialVersion(int n, int[][] queries) {

		long[] values = new long[n];

		int start = n - 1;
		int end = 0;
		for (int q = 0; q < queries.length; q++) {
			start = Math.min(queries[q][START] - 1, start);
			end = Math.max(queries[q][END] - 1, end);
		}

		long max = 0;
		for (int v = start; v <= end; v++) {
			for (int q = 0; q < queries.length; q++) {
				if (queries[q][START] - 1 <= v && v <= queries[q][END] - 1) {
					values[v] += queries[q][VALUE_TO_ADD];
					max = Math.max(max, values[v]);
				}
			}
		}

		return max;

	}

	public static long arrayManipulation(int n, int[][] queries) {

		if (queries.length == 1) {
			return queries[0][VALUE_TO_ADD];
		}

		long max = 0;

		PriorityQueue<Interval> intervals = new PriorityQueue<Interval>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getStart().compareTo(o2.getStart());
			}
		});
		intervals.add(buildInterval(queries, 0));

		for (int q = 1; q < queries.length; q++) {
			Interval current = buildInterval(queries, q);

			List<Interval> mergedIntervals = merge(current, intervals.poll());
			intervals.addAll(mergedIntervals);

		}

		for (Interval interval : intervals) {
			max = Math.max(max, interval.getMaxValue());
		}

		return max;

	}

	private static List<Interval> merge(Interval interval1, Interval interval2) {
		List<Interval> mergedIntervals = new ArrayList<>();

		Integer start1 = interval1.getStart();
		Integer end1 = interval1.getEnd();

		Integer start2 = interval2.getStart();
		Integer end2 = interval2.getEnd();

		if (start1 < start2) {
			int end = Math.min(end1, start2) - 1;
			mergedIntervals.add(new Interval(start1, end, interval1.getMaxValue()));

			if (start2 <= end1) {
				int endMin = Math.min(end1, end2);
				int endMax = Math.max(end1, end2);

				mergedIntervals.add(new Interval(start2, endMin, interval1.getMaxValue() + interval2.getMaxValue()));
				mergedIntervals.add(new Interval(endMin + 1, endMax, interval2.getMaxValue()));
			} else if (end1 < start2) {
				mergedIntervals.add(new Interval(start2, end2, interval2.getMaxValue()));
			}

		} else if (start1 > start2) {
			int end = Math.min(end2, start1) - 1;
			mergedIntervals.add(new Interval(start2, end, interval2.getMaxValue()));

			if (start1 <= end2) {
				int endMin = Math.min(end1, end2);
				int endMax = Math.max(end1, end2);

				mergedIntervals.add(new Interval(start1, endMin, interval1.getMaxValue() + interval2.getMaxValue()));
				mergedIntervals.add(new Interval(endMin + 1, endMax, interval1.getMaxValue()));
			} else if (end2 < start1) {
				mergedIntervals.add(new Interval(start1, end1, interval1.getMaxValue()));
			}
		} else {
			int end = Math.min(end1, end2);
			mergedIntervals.add(new Interval(start2, end, interval1.getMaxValue() + interval2.getMaxValue()));

			if (end1 <= end2) {
				mergedIntervals.add(new Interval(end1 + 1, end2, interval2.getMaxValue()));
			} else {
				mergedIntervals.add(new Interval(end2 + 1, end1, interval1.getMaxValue()));
			}
		}

		return mergedIntervals;
	}

	private static Interval buildInterval(int[][] queries, int i) {
		return new Interval(queries[i][START], queries[i][END], queries[i][VALUE_TO_ADD]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}