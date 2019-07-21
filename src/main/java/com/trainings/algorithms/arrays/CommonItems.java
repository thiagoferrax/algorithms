package com.trainings.algorithms.arrays;

/**
 * Given two arrays, create a function the lets the user knows whether theses
 * arrays contain any common items.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12214986#content
 */
public class CommonItems {
	// Time complexity O(n)
	public boolean solution(char[] A, char[] B) {
		int[] chartToInt = new int[Character.MAX_VALUE + 1];

		for (int i = 0; i < A.length; i++) {
			chartToInt[Character.getNumericValue(A[i])]++;
		}

		for (int i = 0; i < B.length; i++) {
			if (chartToInt[Character.getNumericValue(B[i])] > 0) {
				return true;
			}
		}

		return false;
	}

	// Time complexity O(n*m)
	public boolean bruteForceSolution(char[] A, char[] B) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					return true;
				}
			}
		}

		return false;
	}
}
