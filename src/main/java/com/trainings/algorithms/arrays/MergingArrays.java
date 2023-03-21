package com.trainings.algorithms.arrays;

import java.util.Arrays;

public class MergingArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1st solution
        // Create a new array
        int[] merge = new int[m+n];

        //Input: nums1 = [X,X,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // Two variable for controlling the minimum element on both arrays (idex1, index2)
        int index1 =0, index2=0;
        for (int i = 0; i < m+n; i++) {
            if(index1 < m && index2 < n && nums1[index1] <= nums2[index2]) {
                merge[i] = nums1[index1];
                index1++;
            } else if(index2 < n) {
                merge[i] = nums2[index2];
                index2++;
            } else if (index1 < m) {
                merge[i] = nums1[index1];
                index1++;
            }
        }

        // Clone the array to make nums1 equals merge
        for (int i = 0; i < n + m; i++) {
            nums1[i] = merge[i];
        }

    }
    public void merge1stSolution(int[] nums1, int m, int[] nums2, int n) {
        // 1st solution

        // Create a new array of size m + n: empty array
        int[] merge = new int[m+n];

        // Populate this new array with the elements from nums1 and nums2: not sorted array
        for (int i = 0; i < m; i++) {
            merge[i] = nums1[i];
        }
        System.out.println(Arrays.toString(merge));
        for (int j = 0; j < n; j++) {
            merge[j+m] = nums2[j];
        }
        System.out.println(Arrays.toString(merge));

        // Sort the array
        Arrays.sort(merge);

        System.out.println(Arrays.toString(merge));

        //could make nums1 be with the exact same elements that our new array is
        for (int i = 0; i < merge.length; i++) {
            nums1[i] = merge[i];
        }
    }
}
