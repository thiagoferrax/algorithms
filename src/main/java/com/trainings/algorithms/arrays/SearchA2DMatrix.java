package com.trainings.algorithms.arrays;

import java.util.Arrays;

public class SearchA2DMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {

            // 1st solution O(n2)

            // Creation of an array that has the size of m * n
            //int[] sorted = new int[matrix.length * matrix[0].length];

            // Populate that array and then at the end you already have a sorted array.



            // Will seach in that array using binary search algorithms.

            // 2nd solution

            // Create an array with the number of rows and populate it with last element on each row.
            int[] maximumValuesOnEachRow = new int[matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                maximumValuesOnEachRow[i] = matrix[i][matrix[i].length-1];
            }

            System.out.println(Arrays.toString(maximumValuesOnEachRow));

            // find where the target is...
            // Create a counter and initialize it with zero

            int rowCount = 0;
            for (int i = 0; i < maximumValuesOnEachRow.length; i++) {
                if(target <= maximumValuesOnEachRow[i]) {
                    break;
                }
                rowCount++;
            }

            System.out.println(rowCount);

            // Will seach in that array using binary search algorithms.
            //return Arrays.binarySearch(matrix[rowCount], target) >= 0;

            for (int element: matrix[rowCount]) {
                if(element == target) {
                    return true;
                }
            }

            return false;
        }
    }
