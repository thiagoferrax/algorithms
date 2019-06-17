package com.trainings.algorithms.arrays;

/**
 * Write a function that accepts an integer N and returns a NxN spiral matrix.
 */
public class MatrixSpiral {
	public int[][] solution(int N) {
		int[][] aSolution = new int[N][N];

		int value = 0;

		int startColumn = 0;
		int endColumn = N - 1;
		int startRow = 0;
		int endRow = N - 1;

		int column = 0;
		int row = 0;
		while (value < N * N) {
			aSolution[row][column] = ++value;

			if (row == endRow && column == endColumn) {
				column--;
			} else if (row == endRow && column == startColumn) {
				row--;
				startColumn++;
			} else if (column == endColumn && row != endRow) {
				row++;
				
				if(row == endRow) {
					startRow++;
				}
			} else if (row == endRow && column != startColumn) {
				column--;
				
				if(column == startColumn) {
					endColumn--;
				}
			} else if (column == startColumn && row != startRow) {
				row--;
				
				if(row == startRow) {
					endRow--;
				}
			} else if(column != endColumn ) {
				column++;
			}

		}
		return aSolution;
	}
}
