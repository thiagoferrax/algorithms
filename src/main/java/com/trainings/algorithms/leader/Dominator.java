package com.trainings.algorithms.leader;

import java.util.Arrays;

/**
 * Find an index of an array such that its value occurs at more than half of
 * indices in the array. 
 * Detected time complexity: O(N*log(N)) or O(N)
 */
public class Dominator {
	public int solution(int[] A) {
		int N = A.length;

		if (N == 0 || N == 1) {
			return N - 1;
		}

		int[] B = new int[N];
		for (int n = 0; n < N; n++) {
			B[n] = A[n];
		}

		Arrays.sort(A);

		int toAdd = N % 2 == 0 ? 0 : 1;
		int half = N / 2;

		Integer dominator = null;
		for (int n = 0; n < half + toAdd; n++) {
			if (A[n] == A[n + half]) {
				dominator = A[n];
				break;
			}
		}

		if (dominator == null) {
			return -1;
		}

		for (int n = 0; n < N; n++) {
			if (B[n] == dominator) {
				return n;
			}
		}

		return -1;
	}
}
