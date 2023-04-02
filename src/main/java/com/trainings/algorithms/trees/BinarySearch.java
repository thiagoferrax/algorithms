package com.trainings.algorithms.trees;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/binary-search/">binary-search</a>
 */
public class BinarySearch {
    public int search(int[] numbers, int target) {
        return search(numbers, target, 0, numbers.length - 1);
    }

    private int search(int[] numbers, int target, int start, int end) {
        int index;
        if (numbers[start] == target) {
            index = start;
        } else if (numbers[end] == target) {
            index = end;
        } else if (end - start == 0) {
            index = numbers[start] == target ? start : -1;
        } else if (end - start == 1) {
            index = numbers[start + 1] == target ? start + 1 : -1;
        } else {
            int middleIndex = (start + end) / 2;
            if (numbers[middleIndex] == target) {
                index = middleIndex;
            } else if (numbers[middleIndex] < target) {
                index = search(numbers, target, middleIndex, end);
            } else {
                index = search(numbers, target, start, middleIndex);
            }
        }
        return index;
    }

    public int search1stSolution(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
    }
}
