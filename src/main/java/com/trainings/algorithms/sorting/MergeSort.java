package com.trainings.algorithms.sorting;

public class MergeSort {

	public static int[] sort(int[] values) {
		return mergeSort(values, 0, values.length - 1);
	}

	private static int[] mergeSort(int[] values, int start, int end) {
		int n = end - start + 1;

		if (n < 2) {
			return values;
		}

		int middle = start + (n / 2) - 1;

		mergeSort(values, start, middle);
		mergeSort(values, middle + 1, end);

		merge(values, start, middle, end);

		return values;
	}

	private static void merge(int[] values, int start, int middle, int end) {
		int left = start;
		int right = middle + 1;

		int[] mergedValues = new int[end - start + 1];

		for (int n = 0; left <= middle || right <= end; n++) {
			if (values[left] < values[right]) {
				mergedValues[n] = values[left];
				left++;
			} else {
				mergedValues[n] = values[right];
				right++;
			}
		}

		for (int k = start, n = 0; k <= end; k++, n++) {
			values[k] = mergedValues[n];
		}
	}
}
