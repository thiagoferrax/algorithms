package com.trainings.algorithms.sorting;

import java.util.List;

// https://www.hackerrank.com/challenges/ctci-merge-sort/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
public class CountingInversions {
	public static long countInversions(List<Integer> list) {
		int[] array = list.stream().mapToInt(i -> i).toArray();

		int count = 0;

		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if(swap(array, j - 1, j)) {
					count++;
				}
			}
		}

		return count;
	}

	private static boolean swap(int[] array, int i, int j) {
		boolean swap = array[j - 1] > array[j];
		if (swap) {
			int temp = array[j];
			array[j] = array[j - 1];
			array[j - 1] = temp;
		}
		return swap;
	}
}
