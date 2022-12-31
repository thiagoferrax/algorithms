package com.trainings.algorithms.sorting;

import java.util.Scanner;

/**
 * Given an array, a, of size n distinct elements, sort the array in ascending order using the Bubble Sort algorithm.
 * https://www.hackerrank.com/challenges/30-sorting/problem
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int swaps = bubbleSort(a);

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);

        in.close();

    }

    public static int bubbleSort(int[] a) {
        int n = a.length;
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j);
                    numberOfSwaps++;
                }
            }

            swaps += numberOfSwaps;

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }

        return swaps;
    }

    private static void swap(int[] a, int j) {
        int temp = a[j + 1];
        a[j + 1] = a[j];
        a[j] = temp;
    }
}
