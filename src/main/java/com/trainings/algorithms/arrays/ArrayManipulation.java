package com.trainings.algorithms.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

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
	private Long value;

	public Interval(int start, int end, long value) {
		super();
		this.start = start;
		this.end = end;
		this.value = value;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "start=" + start + ", end=" + end + ", value=" + value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}

class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval i1, Interval i2) {
		return i1.getStart().compareTo(i2.getStart());
	}

}

public class ArrayManipulation {
	private static final long INITIAL_VALUE = 0L;
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

		Map<Integer, Long> pointValueMap = new HashMap<>();
		Set<Integer> points = new HashSet<>();
		for (int[] query : queries) {
			int start = query[START];
			int end = query[END];

			pointValueMap.put(start, INITIAL_VALUE);
			pointValueMap.put(end, INITIAL_VALUE);

			points.add(start);
			points.add(end);
		}
		List<Integer> sortedPoints = new ArrayList<>(points);
		Collections.sort(sortedPoints);

		Map<Integer, Integer> pointIndexMap = new HashMap<>();
		int p = 0;
		for (Integer point : sortedPoints) {
			pointIndexMap.put(point, p++);
		}

		long max = 0;
		
		for (int[] query : queries) {
			int start = query[START];
			int end = query[END];
			long value = query[VALUE_TO_ADD];

			max = Math.max(max, value);

			int startIndex = pointIndexMap.get(start);
			int endIndex = pointIndexMap.get(end);

			for (int index = startIndex; index <= endIndex; index++) {
				int point = sortedPoints.get(index);
				if (pointValueMap.containsKey(point)) {
					long newValue = value + pointValueMap.get(point);
					pointValueMap.put(point, newValue);
					max = Math.max(max, newValue);
				}
			}

		}

		return max;
	}

	public static long arrayManipulationThirdSolution(int n, int[][] queries) {

		if (queries.length == 1) {
			return queries[0][VALUE_TO_ADD];
		}

		Set<Integer> points = new HashSet<>();
		for (int[] query : queries) {
			points.add(query[START]);
			points.add(query[END]);
		}

		List<Integer> pointList = Arrays.asList(points.toArray(new Integer[] {}));
		Collections.sort(pointList);

		List<Interval> intervals = new ArrayList<Interval>();
		for (int i = 1; i < pointList.size(); i++) {
			intervals.add(new Interval(pointList.get(i - 1), pointList.get(i) - 1, 0));
		}
		intervals.add(new Interval(pointList.get(pointList.size() - 1), pointList.get(pointList.size() - 1), 0));

		List<Interval> ordered = getOrderedQueries(queries);

		Map<Integer, Integer> startIndex = new HashMap<>();
		for (int i = 0; i < intervals.size(); i++) {
			Integer start = intervals.get(i).getStart();
			if (!startIndex.containsKey(start)) {
				startIndex.put(start, i);
			}
		}

		long max = 0;
		int count = 0;
		for (Interval queryInterval : ordered) {
			count = startIndex.get(queryInterval.getStart());
			for (int i = count; i < intervals.size(); i++) {
				Interval interval = intervals.get(i);
				if (hasIntersection(interval, queryInterval)) {
					interval.setValue(interval.getValue() + queryInterval.getValue());
					max = Math.max(max, interval.getValue());
				} else {
					break;
				}
			}

		}

		return max;

	}

	private static List<Interval> getOrderedQueries(int[][] queries) {
		List<Interval> orderedQueries = new ArrayList<Interval>();
		for (int[] query : queries) {
			orderedQueries.add(new Interval(query[START], query[END], query[VALUE_TO_ADD]));
		}
		Collections.sort(orderedQueries, new IntervalComparator());
		return orderedQueries;
	}

	public static long arrayManipulationSecondVersion(int n, int[][] queries) {

		if (queries.length == 1) {
			return queries[0][VALUE_TO_ADD];
		}

		PriorityQueue<Interval> intervalsQueue = new PriorityQueue<>(new IntervalComparator());
		for (int q = 0; q < queries.length; q++) {
			Interval interval = buildInterval(queries, q);

			if (intervalsQueue.isEmpty()) {
				intervalsQueue.add(interval);
			} else {
				union(intervalsQueue, interval);
			}
		}

		long max = 0;
		for (Interval interval : intervalsQueue) {
			max = Math.max(max, interval.getValue());
		}

		return max;

	}

	private static void union(PriorityQueue<Interval> intervalsQueue, Interval interval) {
		List<Interval> unionList = new ArrayList<>();
		int initialQueueSize = intervalsQueue.size();
		int hasNoIntersection = 0;

		while (!intervalsQueue.isEmpty()) {
			Interval i = intervalsQueue.peek();

			if (!hasIntersection(i, interval)) {
				hasNoIntersection++;
				unionList.add(intervalsQueue.poll());
				continue;
			} else {
				intervalsQueue.poll();
				unionList.addAll(Arrays.asList(unionWihIntersection(i, interval).toArray(new Interval[] {})));
			}
		}

		if (hasNoIntersection == initialQueueSize) {
			unionList.add(interval);
		}

		intervalsQueue.addAll(unionList);
	}

	public static boolean hasIntersection(Interval i1, Interval i2) {
		Integer start1 = i1.getStart();
		Integer end1 = i1.getEnd();

		Integer start2 = i2.getStart();
		Integer end2 = i2.getEnd();

		return start1 <= start2 && start2 <= end1 || start1 <= end2 && end2 <= end1
				|| start2 <= start1 && start1 <= end2 || start2 <= end1 && end1 <= end2;
	}

	public static List<Interval> unionWihIntersection(Interval i1, Interval i2) {
		List<Interval> unionQueue = new ArrayList<>();

		oneIntervalCompletlyInTheOther(unionQueue, i1, i2);
		oneIntervalCompletlyInTheOther(unionQueue, i2, i1);
		oneIntervalStartingBeforeTheOther(unionQueue, i1, i2);
		oneIntervalStartingBeforeTheOther(unionQueue, i2, i1);

		return unionQueue;
	}

	private static void oneIntervalStartingBeforeTheOther(List<Interval> unionQueue, Interval i1, Interval i2) {
		Integer start1 = i1.getStart();
		Integer end1 = i1.getEnd();

		Integer start2 = i2.getStart();
		Integer end2 = i2.getEnd();

		if (start1 <= start2 && start2 <= end1 && end2 > end1) {
			if (start1 < start2) {
				unionQueue.add(new Interval(start1, start2 - 1, i1.getValue()));
			}
			unionQueue.add(new Interval(start2, end1, i1.getValue() + i2.getValue()));
			unionQueue.add(new Interval(end1 + 1, end2, i2.getValue()));
		}
	}

	private static void oneIntervalCompletlyInTheOther(List<Interval> unionQueue, Interval i1, Interval i2) {
		Integer start1 = i1.getStart();
		Integer end1 = i1.getEnd();

		Integer start2 = i2.getStart();
		Integer end2 = i2.getEnd();

		if (start1 <= start2 && start2 <= end1 && start1 <= end2 && end2 <= end1) {
			if (start1 < start2) {
				unionQueue.add(new Interval(start1, start2 - 1, i1.getValue()));
			}

			unionQueue.add(new Interval(start2, end2, i1.getValue() + i2.getValue()));

			if (end2 < end1) {
				unionQueue.add(new Interval(end2 + 1, end1, i1.getValue()));
			}
		}
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