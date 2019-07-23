package com.trainings.algorithms.arrays;

/**
 * Merge two sorted arrays of integers.
 * Time complexity: O(m+n)
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12309362#overview
 */
public class MergeSortedArrays {
	public int[] merge(int[] left, int[] right) {
		int m = left.length;
		int n = right.length;
		
		int[] solution = new int[m + n];

		if (m == 0) {
			return right;
		} 
		if (n == 0) {
			return left;
		}
		
		for (int s = 0, l = 0, r = 0; s < solution.length; s++) {
			if(l == m) {
				solution[s] = right[r];
				r++;
			} else if(r == n) {
				solution[s] = left[l];
				l++;
			} else if(left[l] <= right[r]) {
				solution[s] = left[l];
				l++;
			} else {
				solution[s] = right[r];
				r++;
			}
		}
		
		return solution;
	}
}
