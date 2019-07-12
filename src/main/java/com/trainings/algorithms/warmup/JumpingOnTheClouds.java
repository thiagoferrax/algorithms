package com.trainings.algorithms.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Determine the minimum number of jumps it will take Emma to jump from her
 * starting position to the last cloud. It is always possible to win the game.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class JumpingOnTheClouds {
	private static final int SAFE_CLOUD = 0;
	private static final int MAX_JUMP = 2;

	// Complete the jumpingOnClouds function below.
	public static int jumpingOnClouds(int[] c) {
		int S = c.length;
		int jumps = 0;
		int step = 0;
		while (step < S - 1) {
			if (step + MAX_JUMP < S && c[step + MAX_JUMP] == SAFE_CLOUD) {
				step += MAX_JUMP;
			} else {
				step++;
			}
			jumps++;
		}
		return jumps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
