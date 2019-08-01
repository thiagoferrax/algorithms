package com.trainings.algorithms.sorting;

public class SelectionSort {

	public static int[] sort(int[] values) {
		int n = values.length;
		if(n < 2) {
			return values;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(values[i] > values[j]) {
					swap(values, i, j);
				}
			}
		}
				
		return values;
	}

	private static void swap(int[] values, int i, int j) {
		int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

}
