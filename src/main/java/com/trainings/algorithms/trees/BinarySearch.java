package com.trainings.algorithms.trees;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/binary-search/">binary-search</a>
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
