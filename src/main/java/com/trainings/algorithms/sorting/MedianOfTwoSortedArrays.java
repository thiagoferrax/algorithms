package com.trainings.algorithms.sorting;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] is, int[] is2) {

        int left = 0;
        int right = 0;

        int size = is.length + is2.length;
        int[] merged = new int[size];

        int index = 0;
        while (left < is.length && right < is2.length) {
            if (is[left] <= is2[right]) {
                merged[index] = is[left];
                left++;
            } else {
                merged[index] = is2[right];
                right++;
            }
            index++;
        }
        while (left < is.length) {
            merged[index] = is[left];
            left++;
            index++;
        }
        while (right < is2.length) {
            merged[index] = is2[right];
            right++;
            index++;
        }

        return size % 2 == 0 ? (merged[(size / 2) - 1] + merged[size / 2]) / 2.0 : merged[(size / 2)];
    }

}
