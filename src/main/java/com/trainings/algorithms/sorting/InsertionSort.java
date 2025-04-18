package com.trainings.algorithms.sorting;

/**
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12398796#content
 */
public class InsertionSort {

    public static int[] sort(int[] values) {
        int n = values.length;
        if (n < 2) {
            return values;
        }

        for (int i = 0; i < n - 1; i++) {
            int valueToInsert = values[i + 1];
            int insertPosition = i + 1;
            for (int j = i; j >= 0; j--) {
                if (valueToInsert < values[j]) {
                    insertPosition = j;
                }
            }

            for (int k = i + 1; k > insertPosition; k--) {
                values[k] = values[k - 1];
            }

            values[insertPosition] = valueToInsert;
        }

        return values;
    }

    public static int[] insertionSort(int[] values) {
        for(int i = 0; i < values.length; i++) {
            int postitionToInsert = i;
            int valueToInsert = values[i];
            for(int j = i-1; j >=0; j--) {
                if(values[i] < values[j]) {
                   postitionToInsert = j;
                   valueToInsert = values[i];
                }
            }
            for(int j = i; j > postitionToInsert; j--) {
                values[j] = values[j-1];
            }
            values[postitionToInsert] = valueToInsert;
        }
        return values;
    }
}

