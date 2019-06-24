package com.trainings.algorithms.prefixsums;

/**
 * Find the minimal average of any slice containing at least two elements.
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 */
public class MinAvgTwoSlice {
	//O(N ** 2)
	public int solution(int[] A) {
		int N = A.length;

		float[][] slice = new float[N-1][N];
		int[][] sum = new int[N-1][N];

		float minSlice = 100000 * 10000;
		int aSolution = 0;
		for (int n = 0; n < N-1; n++) {
			sum[n][n] = A[n];
			for (int m = n + 1; m < N; m++) {
				sum[n][m] = sum[n][m - 1] + A[m];
				slice[n][m] = ((float)sum[n][m]) / (m - n + 1);

				if (slice[n][m] < minSlice) {
					minSlice = slice[n][m];
					aSolution = n;
				}
			}
		}

		return aSolution;
	}

}
