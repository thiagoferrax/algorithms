package com.trainings.algorithms.arrays;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">...</a>
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] ints) {
        if (ints.length == 1) {
            return ints[0];
        }

        int min = ints[0];
        if (ints[ints.length - 1] <= min) {
            min = ints[ints.length - 1];
            for (int i = ints.length - 2; i >= 0; i--) {
                if (ints[i] <= min) {
                    min = ints[i];
                } else {
                    break;
                }
            }
        }

        return min;
    }
}
