package com.trainings.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
public class MergeTwoSortedArrays {

	public static int[] mergeArrays(int[] arr1, int[] arr2, int n1, int n2) {
		List<Integer> l1 = asList(arr1);
		l1.addAll(asList(arr2));
		Collections.sort(l1);
		return l1.stream().mapToInt(i -> i).toArray();
	}

	private static List<Integer> asList(int[] arr1) {
		return Arrays.stream(arr1).boxed().collect(Collectors.toList());
	}

	public static int[] mergeArrays1stSolution(int[] arr1, int[] arr2, int n1, int n2) {

		// Create the new array that is the merge between arr1 and arr2.
		int[] merged = new int[arr1.length + arr2.length];

		int index1 = 0;
		int index2 = 0;

		int index = 0;

		// Iterate through arrays adding values in merged according to comparisons.
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
