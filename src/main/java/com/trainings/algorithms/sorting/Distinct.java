package com.trainings.algorithms.sorting;

import java.util.Arrays;

/**
 * Compute number of distinct values in an array.
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 * Detected time complexity: O(N*log(N)) or O(N)
 */
public class Distinct {
    public int solution(int[] A) {
        int N = A.length;

        Arrays.sort(A);

        if (N == 0 || N == 1 || (N == 2 && A[0] != A[1])) {
            return N;
        } else if (A[0] == A[N - 1]) {
            return 1;
        }

        int count = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] != A[i - 1]) {
                count++;
            }
        }

        return count;
    }
}
