package com.trainings.algorithms.sorting;

public class SelectionSort {

    public static int[] sort(int[] values) {
        int n = values.length;
        if (n < 2) {
            return values;
        }

        for (int i = 0; i < n; i++) {
            int smaller_position = i;
            for (int j = i + 1; j < n; j++) {
                if (values[smaller_position] > values[j]) {
                    smaller_position = j;
                }
            }
            swap(values, i, smaller_position);
        }

        return values;
    }

    private static void swap(int[] values, int i, int j) {
        if (i != j) {
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
    }

}
