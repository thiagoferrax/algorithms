package com.trainings.algorithms.prefixsums;

/**
 * Find the minimal average of any slice containing at least two elements.
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 */
public class MinAvgTwoSlice {
	// O(N ** 2)
	public int solution(int[] A) {
		int N = A.length;

		int[] sum = new int[N];
		
		sum[0] = A[0];
		for (int n = 1; n < N; n++) {
			sum[n] = sum[n-1] + A[n];
		}

		int aSolution = 0;
		float minSlice = 100000 * 10000;
		for (int n = 0; n < N - 1; n++) {
			for (int m = n + 1; m < N; m++) {
				float sum_N_M = n >= 1 ? sum[m] - sum[n - 1] : sum[m];
				float slice_N_M = sum_N_M / (m - n + 1);
				
				if (slice_N_M < minSlice) {
					minSlice = slice_N_M;
					aSolution = n;
				}
			}
		}

		return aSolution;
	}

}
