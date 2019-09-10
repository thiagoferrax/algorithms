package com.trainings.algorithms.dictionariesandhashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two strings, determine if they share a common substring.
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {
	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();

		boolean shareCommonSubstring = charArray1.length < charArray2.length
				? shareCommonSubstring(charArray1, charArray2)
				: shareCommonSubstring(charArray2, charArray1);

		return shareCommonSubstring ? "YES" : "NO";
	}

	private static boolean shareCommonSubstring(char[] charArray1, char[] charArray2) {
		boolean shareCommonSubstring = false;

		for (int c1 = 0; c1 < charArray1.length; c1++) {
			if (Arrays.binarySearch(charArray2, charArray1[c1]) >= 0) {
				shareCommonSubstring = true;
				break;
			}
		}

		return shareCommonSubstring;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}