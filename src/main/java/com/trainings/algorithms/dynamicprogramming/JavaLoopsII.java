package com.trainings.algorithms.dynamicprogramming;

import java.util.Scanner;
import java.util.stream.Stream;

// https://www.hackerrank.com/challenges/java-loops/problem
public class JavaLoopsII {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int q = scanner.nextInt();

		int[][] queries = new int[q][3];

		for (int i = 0; i < q; i++) {
			String input = scanner.nextLine();
			queries[i] = extract(input);
			System.out.println(queries[i]);
		}

		scanner.close();

		System.out.println(calculate(q, queries));
	}

	public static int[] extract(String input) {
		return Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	public static String calculate(int q, int[][] queries) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < queries.length; i++) {

			int a = queries[i][0];
			int b = queries[i][1];
			int n = queries[i][2];

			int[] result = new int[n];

			result[0] = a + b;
			builder.append(result[0]);
			for (int j = 1; j < n; j++) {
				result[j] = result[j - 1] + (int) Math.pow(2, j) * b;
				builder.append(" " + result[j]);
			}

			if (i + 1 < queries.length) {
				builder.append("\n");
			}
		}

		return builder.toString();
	}

}
