package com.trainings.algorithms.leader;

import java.util.Arrays;

/**
 * Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S]
 * and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 */
public class EquiLeader {

	// Detected time complexity: O(N ** 2)
	public int solution(int[] A) {

		int N = A.length;

		int leaders = 0;
		for (int n = 0; n < N - 1; n++) {
			Integer leftLeader = getLeader(A, 0, n);
			Integer rightLeader = getLeader(A, n + 1, N - 1);

			if (leftLeader != null && leftLeader.equals(rightLeader)) {
				leaders++;
			}
		}

		return leaders;
	}

	private Integer getLeader(int[] A, int start, int end) {
		int N = end - start + 1;

		if (N == 1) {
			return A[start];
		} else if (N == 2) {
			return A[start] == A[end] ? A[start] : null;
		}

		int[] newA = new int[N];
		for (int n = start, m = 0; n <= end; n++, m++) {
			newA[m] = A[n];
		}

		Arrays.sort(newA);

		int toAdd = N % 2 == 0 ? 0 : 1;
		int half = N / 2;
		for (int n = 0; n < half + toAdd; n++) {
			if (newA[n] == newA[n + half]) {
				return newA[n];
			}
		}

		return null;
	}
}
