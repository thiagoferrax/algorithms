package com.trainings.algorithms.arrays;

import java.util.Scanner;

/**
 * Print an integer denoting the minimum number of bribes needed to get the
 * queue into its final state. Print Too chaotic if the state is invalid, i.e.
 * it requires a person to have bribed more than 2 people.
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class NewYearChaos {
	private static final int MAX_BRIDES_PER_PERSON = 2;

	static void minimumBribes(int[] q) {
		int N = q.length;

		int[] bribesCounts = new int[N];

		boolean tooChaotice = false, initialState = false;
		int b = 0, bribes = 0, noBribes = 0;
		while (!tooChaotice && !initialState) {
			if (b >= N - 1) {
				b = 0;
				noBribes = 0;
			}

			if (q[b] > q[b + 1]) {
				reverseBribe(q, b);
				bribes++;

				reverseBribe(bribesCounts, b);

				bribesCounts[b + 1]++;
				if (bribesCounts[b + 1] > MAX_BRIDES_PER_PERSON) {
					tooChaotice = true;
					break;
				}

				b++;
			} else {
				noBribes++;
				b++;

				if (noBribes == N - 1) {
					initialState = true;
				}
			}
		}

		System.out.println(tooChaotice ? "Too chaotic" : bribes);
	}

	private static void reverseBribe(int[] q, int b) {
		int temp = q[b + 1];
		q[b + 1] = q[b];
		q[b] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
