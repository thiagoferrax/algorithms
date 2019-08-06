package com.trainings.algorithms.sorting;

public class HeapSort {

	public static int[] sort(int[] values) {
		int length = values.length;
		if (length < 2) {
			return values;
		}

		while (length > 0) {
			for (int i = 0; i < length; i++) {
				heapMaxfy(values, length, i);
			}
			swap(values, length - 1, 0);
			length--;
		}

		return values;
	}

	private static void heapMaxfy(int[] values, int length, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < length && values[left] > values[largest]) {
			largest = left;
		}

		if (right < length && values[right] > values[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(values, i, largest);
			//heapMaxfy(values, length - 1, largest);
		}
	}

	private static void swap(int[] values, int i, int largest) {
		int temp = values[i];
		values[i] = values[largest];
		values[largest] = temp;
	}

}
