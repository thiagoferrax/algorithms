package com.trainings.algorithms.countingelements;

import java.util.Arrays;

/**
 * Find the smallest positive integer that does not occur in a given sequence.
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 * Detected time complexity: O(N) or O(N * log(N))
 */
public class MissingInteger {
	public int solution(int[] A) {

		Arrays.sort(A);

		int N = A.length;
		if (N == 0 || A[0] > 1 || A[N - 1] <= 0) {
			return 1;
		}

		int n = avoidNegativeIntegers(A, N);
		
		for (; n < N; n++) {

			if (A[n] < 0)
				continue;

			int before = A[n - 1] <= 0 ? 0 : A[n - 1];

			if (A[n] - before > 1) {
				return before + 1;
			}
		}

		return A[N - 1] + 1;
	}

	private int avoidNegativeIntegers(int[] A, int N) {
		int n = 1;
		int half = Math.max(n, N/2);

		while(half < N && A[half] <= 0) {
			n = half+1;
			half += (N-half)/2;
		}
		return n;
	}
}
