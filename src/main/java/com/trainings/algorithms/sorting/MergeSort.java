package com.trainings.algorithms.sorting;

public class MergeSort {

    public static int[] sort(int[] values) {
        return mergeSort(values, 0, values.length - 1);
    }

    private static int[] mergeSort(int[] values, int start, int end) {
        int length = end - start + 1;

        if (length < 2) {
            return values;
        }

        if (length == 2) {
            if (values[start] > values[end]) {
                swap(values, start, end);
            }
            return values;
        }

        int middle = start + (length / 2);

        mergeSort(values, start, middle);
        mergeSort(values, middle + 1, end);
        merge(values, start, middle, end);

        return values;
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
}
