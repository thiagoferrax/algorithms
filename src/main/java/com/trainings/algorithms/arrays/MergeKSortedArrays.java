package com.trainings.algorithms.arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeKSortedArrays {
	public static int[] mergeKArrays(int[][] arr) {

		int nArrays = arr.length;
		int arrayLength = arr[0].length;

		int[] indexes = new int[nArrays];
		int[] merged = new int[nArrays * arrayLength];

		int m = 0;
		int row = 0;
		Integer min = 0;

		List<Integer> availableArrays = IntStream.rangeClosed(0, nArrays - 1).boxed().collect(Collectors.toList());

		int minimum = arr[row][indexes[row]];
		while (availableArrays.size() > 0) {
			if (arr[row][indexes[row]] <= minimum) {
				minimum = arr[row][indexes[row]];
				min = row;
			}

			int nextRow = availableArrays.indexOf(row) + 1;
			if (nextRow < availableArrays.size()) {
				row = availableArrays.get(nextRow);
			} else {
				merged[m++] = minimum;
				indexes[min]++;

				if (indexes[min] == arrayLength) {
					availableArrays.remove(min);
				}

				if (availableArrays.size() > 0) {
					row = availableArrays.get(0);
					minimum = arr[row][indexes[row]];
				}
			}
		}

		return merged;
	}
}
