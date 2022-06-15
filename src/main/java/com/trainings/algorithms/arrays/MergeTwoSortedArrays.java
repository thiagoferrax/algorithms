package com.trainings.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
public class MergeTwoSortedArrays {

	public static int[] mergeArrays2ndSolution(int[] arr1, int[] arr2, int n1, int n2) {
		List<Integer> l1 = asList(arr1);
		l1.addAll(asList(arr2));
		Collections.sort(l1);
		return l1.stream().mapToInt(i -> i).toArray();
	}

	private static List<Integer> asList(int[] arr1) {
		return Arrays.stream(arr1).boxed().collect(Collectors.toList());
	}

	public static int[] mergeArrays(int[] arr1, int[] arr2, int n1, int n2) {

		int[] merged = new int[n1 + n2];

		int m = 0, a1 = 0, a2 = 0;
		while (a1 < n1 || a2 < n2) {
			if (a1 >= n1) {
				merged[m++] = arr2[a2++];
			} else if (a2 >= n2) {
				merged[m++] = arr1[a1++];
			} else if (arr1[a1] <= arr2[a2]) {
				merged[m++] = arr1[a1++];
			} else {
				merged[m++] = arr2[a2++];
			}
		}

		return merged;
	}
	
	public static int[] mergeArrays(int[] arr1, int[] arr2, int limit) {

		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int[] merged = new int[Math.min(n1 + n2, limit)];

		int m = 0, a1 = 0, a2 = 0;
		while ((a1 < n1 || a2 < n2) && m < limit) {
			if (a1 >= n1) {
				merged[m++] = arr2[a2++];
			} else if (a2 >= n2) {
				merged[m++] = arr1[a1++];
			} else if (arr1[a1] <= arr2[a2]) {
				merged[m++] = arr1[a1++];
			} else {
				merged[m++] = arr2[a2++];
			}
		}

		return merged;
	}
	
	public static int[] mergeArrays2ndSolution(int[] arr1, int[] arr2, int limit) {
		List<Integer> l1 = asList(arr1);
		l1.addAll(asList(arr2));
		Collections.sort(l1);
		return l1.stream().limit(limit).mapToInt(i -> i).toArray();
	}
}
