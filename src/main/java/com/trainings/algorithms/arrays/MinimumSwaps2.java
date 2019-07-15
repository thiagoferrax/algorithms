package com.trainings.algorithms.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * You are given an unordered array consisting of consecutive integers [1, 2, 3,
 * ..., n] without any duplicates. You are allowed to swap any two elements. You
 * need to find the minimum number of swaps required to sort the array in
 * ascending order.
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
public class MinimumSwaps2 {
	static int minimumSwaps(int[] arr) {

		int N = arr.length;

		int n = 0, swaps = 0;
		while (n < N) {
			if (arr[n] == n + 1) {
				n++;
				continue;
			} else {
				swap(arr, n);
				swaps++;
			}
		}

		return swaps;
	}

	private static void swap(int[] arr, int n) {
		int value = arr[n];
		arr[n] = arr[value - 1];
		arr[value - 1] = value;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
