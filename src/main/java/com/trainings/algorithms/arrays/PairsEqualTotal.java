package com.trainings.algorithms.arrays;

import java.util.Arrays;

/**
 * Given an array and a value, it checks to see if it contains any pair of items
 * whose sum results in the specified value.
 * https://www.youtube.com/watch?v=XKu_SEDAykw
 */
public class PairsEqualTotal {

    // Time complexity O(n*log(n))
    public boolean hasPairsThatSumEqualsTotal(int[] array, int total) {
        Arrays.sort(array);

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int sum = array[start] + array[end];
            if (sum == total) {
                return true;
            } else if (sum < total) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }

    // Brute force solution, time complexity O(n²)
    public boolean hasPairsThatSumEqualsTotalBruteForce(int[] array, int total) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] + array[j] == total) {
                    return true;
                }
            }
        }

        return false;
    }

}
