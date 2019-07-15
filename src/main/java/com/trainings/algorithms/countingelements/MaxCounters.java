package com.trainings.algorithms.countingelements;

/*
 * Calculate the values of counters after applying all alternating operations: 
 * increase counter by 1; set value of all counters to current maximum.
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters {
	// Detected time complexity: O(N * M)
	public int[] solution(int N, int[] A) {
		int[] aSolution = new int[N];
		
		int M = A.length;
		int max = 0;
		for (int m = 0; m < M; m++) {
			int X = A[m];
			if (X >= 1 && X <= N) {
				aSolution[X - 1]++;
				max = Math.max(max, aSolution[X - 1]);
			} else if (X == N + 1) {
				for (int n = 0; n < N; n++) {
					aSolution[n] = max;
				}
			}
		}

		return aSolution;
	}

	// Detected time complexity: O(N + M)
	public int[] bestSolution(int N, int[] A) {

		int[] aSolution = new int[N];
		
		int max = 0;
		int maxN1 = 0;
		int M = A.length;
		for (int m = 0; m < M; m++) {

			if (A[m] >= 1 && A[m] <= N) {
				int X = A[m];

				aSolution[X - 1] = (aSolution[X - 1] > maxN1 ? aSolution[X - 1] : maxN1) + 1;
				if (aSolution[X - 1] > max) {
					max = aSolution[X - 1];
				}
			} else if (A[m] == N + 1) {
				maxN1 = max;
			}

		}

		for (int i = 0; i < N; i++) {
			if (aSolution[i] < maxN1) {
				aSolution[i] = maxN1;
			}
		}

		return aSolution;
	}

}
