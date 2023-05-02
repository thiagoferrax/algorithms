package com.trainings.algorithms.arrays;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        // e(0,0) = te(0,0)
        // e(0,1) = te(1,0)
        // e(r,c) = te(c,r)

        // Creating a transpose matrix m 4 X 3 => tm 3 X 4
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transposeMatrix = new int[columns][rows];

        // Iterate through the matrix and populate the transpose matrix considering the following formula te(i,j) = e(j,i)
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                transposeMatrix[c][r] = matrix[r][c];
                System.out.print(transposeMatrix[c][r]);
            }
            System.out.println();
        }

        // return the transpose matrix.
        return transposeMatrix;
    }

}
