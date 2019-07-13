package com.trainings.algorithms.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Given an integer, , find and print the number of letter a's in the first n
 * letters of Lilah's infinite string.
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
 */
public class RepeatedString {
	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long numberOfAs = getNumberOfAs(s, n);

		if (n > s.length()) {
			long repeats = n / s.length();
			numberOfAs = (repeats * numberOfAs) + getNumberOfAs(s, n % s.length());
		}

		return numberOfAs;
	}

	private static long getNumberOfAs(String s, long n) {
		long numberOfAs = 0;
		for (int i = 0; i < Math.min(s.length(), n); i++) {
			if (s.charAt(i) == 'a') {
				numberOfAs++;
			}
		}
		return numberOfAs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}