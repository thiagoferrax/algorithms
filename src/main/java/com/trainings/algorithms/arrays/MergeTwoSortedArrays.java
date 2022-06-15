package com.trainings.algorithms.arrays;

// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
public class MergeTwoSortedArrays {
	public static int[] mergeArrays(int[] arr1, int[] arr2, int n1, int n2) {

		int[] merged = new int[arr1.length + arr2.length];

		int index1 = 0;
		int index2 = 0;

		int index = 0;
		while (index1 < arr1.length || index2 < arr2.length) {
			if (index1 >= arr1.length) {
				merged[index++] = arr2[index2++];
			} else if (index2 >= arr2.length) {
				merged[index++] = arr2[index2++];
			} else if (arr1[index1] <= arr2[index2]) {
				merged[index++] = arr1[index1++];
			} else {
				merged[index++] = arr2[index2++];
			}
		}

		return merged;
	}
}
