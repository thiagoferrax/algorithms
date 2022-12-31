package com.trainings.algorithms.countingelements;

import java.util.Arrays;

/**
 * Check whether array A is a permutation.
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 * Detected time complexity: O(N) or O(N * log(N))
 */
public class PermCheck {
    public int solution(int[] A) {
        Arrays.sort(A);

        int length = A.length;

        if (length == 0 || A[0] != 1) {
            return 0;
        } else if (length == 1) {
            return 1;
        }

        for (int i = 1; i < length; i++) {
            if (A[i] == A[i - 1] || A[i] - A[i - 1] > 1) {
                return 0;
            }
        }

        return 1;
    }
}
