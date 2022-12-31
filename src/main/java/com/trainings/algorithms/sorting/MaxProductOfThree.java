package com.trainings.algorithms.sorting;

import java.util.Arrays;

/**
 * Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 * https://app.codility.com/programmers/lessons/6-sorting/
 */
public class MaxProductOfThree {
    // Detected time complexity: O(N**3)
    public int firstSolution(int[] A) {
        int N = A.length;

        int maximalProduct = -1001;

        for (int p = 0; p < N - 2; p++) {
            for (int q = p + 1; q < N - 1; q++) {
                for (int r = q + 1; r < N; r++) {
                    maximalProduct = Math.max(maximalProduct, A[p] * A[q] * A[r]);
                }
            }
        }

        return maximalProduct;
    }

    // Detected time complexity: O(N * log(N))
    public int solution(int[] A) {
        int N = A.length;

        Arrays.sort(A);

        return Math.max(A[0] * A[1] * A[N - 1], A[N - 3] * A[N - 2] * A[N - 1]);
    }
}
