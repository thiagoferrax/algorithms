package com.trainings.algorithms.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortCountingInversions {
	// Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	return mergeSort(arr, 0, arr.length - 1, 0);
    }
    
    private static int mergeSort(int[] values, int start, int end, int swaps) {
		int length = end - start + 1;

		if (length < 2) {
			return swaps;
		}

		if (length == 2) {
			if (values[start] > values[end]) {
				swap(values, start, end);
				swaps++;
			}
			return swaps;
		}

		int middle = start + (length / 2);

		swaps = mergeSort(values, start, middle, swaps);
		swaps = mergeSort(values, middle + 1, end, swaps);
		merge(values, start, middle, end);

		return swaps;
	}

	private static void swap(int[] values, int start, int end) {
		int temp = values[start];
		values[start] = values[end];
		values[end] = temp;
	}

	private static void merge(int[] values, int start, int middle, int end) {
		int left = start;
		int right = middle + 1;

		int[] mergedValues = new int[end - start + 1];

		for (int n = 0; left <= middle || right <= end; n++) {
			if (left == middle + 1 && right <= end) { // There is no more elements in he left side
				mergedValues[n] = values[right];
				right++;
			} else if (right == end + 1 && left <= middle) { // There is no more elements in he right side
				mergedValues[n] = values[left];
				left++;
			} else if (values[left] < values[right]) {
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

