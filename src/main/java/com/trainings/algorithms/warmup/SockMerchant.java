package com.trainings.algorithms.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Given an array of integers representing the color of each sock, determine how
 * many pairs of socks with matching colors there are.
 */
public class SockMerchant {

	private static final int MAX_VALUE = 100;

	// Complete the sockMerchant function below.
	public static int sockMerchant(int n, int[] ar) {

		int[] values = new int[MAX_VALUE + 1];

		int pairs = 0;
		for (int i = 0; i < n; i++) {
			values[ar[i]]++;
			if (values[ar[i]] % 2 == 0) {
				pairs++;
			}
		}

		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}