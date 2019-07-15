package com.trainings.algorithms.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
public class ArrayManipulation {
	private static final int VALUE_TO_ADD = 2;
	private static final int END = 1;
	private static final int START = 0;

	static long arrayManipulation(int n, int[][] queries) {

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