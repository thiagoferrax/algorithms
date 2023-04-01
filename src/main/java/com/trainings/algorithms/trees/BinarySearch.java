package com.trainings.algorithms.trees;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/binary-search/">binary-search</a>
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int index = search(nums, target, 0, nums.length-1);
        return index >= 0 ? index : -1;
    }

    private int search(int[] nums, int target, int start, int end) {
        if(nums[start] == target) {
            return start;
        } else if(nums[end] == target) {
            return end;
        } else if(end-start == 0) {
            return nums[start] == target ? start : -1;
        } else if(end - start == 1) {
            return nums[start+1] == target ? start + 1 : -1;
        }

        int middleIndex = getMiddleElementIndex(start, end);
        if(nums[middleIndex]== target) {
            return middleIndex;
        } else if(nums[middleIndex] < target) {
            return search(nums, target, middleIndex, end);
        } else {
            return search(nums, target, start, middleIndex);
        }
    }

    private int getMiddleElementIndex(int start, int end) {
        return (start + end)/2;
    }

    public int search1stSolution(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
