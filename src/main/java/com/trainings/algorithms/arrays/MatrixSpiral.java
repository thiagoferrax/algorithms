package com.trainings.algorithms.arrays;

/**
 * Write a function that accepts an integer N and returns a NxN spiral matrix.
 * https://www.udemy.com/coding-interview-bootcamp-algorithms-and-data-structure/
 * Detected time complexity: O(N)
 */
public class MatrixSpiral {
	public int[][] solution(int N) {
		int row = 0;
		int column = 0;
		int startRow = 0;
		int endRow = N - 1;
		int startColumn = 0;
		int endColumn = N - 1;

		
		int[][] aSolution = new int[N][N];

		for (int value = 1; value <= N * N; value++) {
			aSolution[row][column] = value;

			if (row == endRow && column == endColumn) {
				column--;
			} else if (row == endRow && column == startColumn) {
				row--;
			} else if (row != startRow && column == startColumn) {
				row--;

				if (row == startRow) {
					startColumn++;
					endRow--;
				}
			} else if (row != endRow && column == endColumn) {
				row++;
				if (row == endRow) startRow++;				
			} else if (row == endRow && column != startColumn) {
				column--;
				if (column == startColumn) endColumn--;
			} else {
				column++;
			}
		}

		return aSolution;
	}
}