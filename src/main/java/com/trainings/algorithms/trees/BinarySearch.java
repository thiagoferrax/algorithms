package com.trainings.algorithms.trees;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/binary-search/">binary-search</a>
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        int index = -1;
        if (nums[start] == target) {
            index = start;
        } else if (nums[end] == target) {
            index = end;
        } else if (end - start == 0) {
            index = nums[start] == target ? start : -1;
        } else if (end - start == 1) {
            index = nums[start + 1] == target ? start + 1 : -1;
        } else {
            int middleIndex = (start + end) / 2;
            if (nums[middleIndex] == target) {
                index = middleIndex;
            } else if (nums[middleIndex] < target) {
                index = search(nums, target, middleIndex, end);
            } else {
                index = search(nums, target, start, middleIndex);
            }
        }
        return index;
    }

    public int search1stSolution(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
