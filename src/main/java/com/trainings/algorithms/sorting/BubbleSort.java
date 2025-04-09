package com.trainings.algorithms.sorting;

import java.util.Arrays;
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
        int swaps = 0;
        int previousSwaps = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] > a[i]) {
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                    swaps++;
                }
            }
            if(previousSwaps == swaps) {
                break;
            }
            previousSwaps = swaps;
        }
        return swaps;
    }

    public static int bubbleSort1stSolution(int[] a) {
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

    public static int bubbleSort3rdSolution(int[] a) {
        if(a == null) return 0;

        int swaps = 0;
        boolean swapped;
        int j = 0;

        for (; j < a.length - 1; j++) {
            swapped = false;
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println(j);
        System.out.println(Arrays.toString(a));

        return swaps;
    }

    private static void swap(int[] a, int j) {
        int temp = a[j + 1];
        a[j + 1] = a[j];
        a[j] = temp;
    }
}
