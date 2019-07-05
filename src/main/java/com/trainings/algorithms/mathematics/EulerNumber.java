package com.trainings.algorithms.mathematics;

import java.util.Scanner;

/**
 * Given a value of n, calculate the approximate value of e by the Taylor
 * series. 
 * https://ucoder.com.br/problems/1007/
 */
public class EulerNumber {
	private static final int MAX_N_VALUE = 12;
	private static int[] factorialCache = new int[MAX_N_VALUE + 1];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int limit = scan.nextInt();

		while (limit >= 0) {
			float eulerNumber = getEulerNumber(limit);
			System.out.printf("%.6f\n", eulerNumber);
			limit = scan.nextInt();
		}

		scan.close();

	}

	private static float getEulerNumber(int limit) {
		float eulerNumber = 0;
		for (int n = 0; n <= limit; n++) {
			eulerNumber += 1 / factorial(n);
		}

		return eulerNumber;
	}

	private static float factorial(int limit) {
		if (limit == 0 || limit == 1) {
			return 1;
		}

		if (factorialCache[limit] != 0) {
			return factorialCache[limit];
		}

		return limit * factorial(limit - 1);
	}
}
