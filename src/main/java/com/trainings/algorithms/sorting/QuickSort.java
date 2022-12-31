package com.trainings.algorithms.sorting;


/**
 *
 */
public class QuickSort {

    public static int[] sort(int[] values) {
        return quickSort(values, 0, values.length - 1);
    }

    private static int[] quickSort(int[] values, int start, int end) {
        int length = end - start + 1;

        if (length < 2) {
            return values;
        }

        if (length == 2) {
            if (values[start] > values[end]) {
                swap(values, start, end);
            }
        }

        int selected = start;
        int compareTo = end;
        boolean left = true;

        while (selected != compareTo) {
            if (left) {
                if (values[selected] > values[compareTo]) {
                    swap(values, selected, compareTo);

                    int temp = selected;
                    selected = compareTo;
                    compareTo = temp + 1;
                    left = false;
                } else {
                    compareTo--;
                }
            } else {
                if (values[selected] < values[compareTo]) {
                    swap(values, selected, compareTo);

                    int temp = selected;
                    selected = compareTo;
                    compareTo = temp - 1;
                    left = true;
                } else {
                    compareTo++;
                }
            }
        }

        if (selected == start) {
            quickSort(values, selected + 1, end);
        } else if (selected == end) {
            quickSort(values, start, end - 1);
        } else {
            quickSort(values, start, selected - 1);
            quickSort(values, selected + 1, end);
        }

        return values;
    }

    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

}
