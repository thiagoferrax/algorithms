package com.trainings.algorithms.arrays;

/**
 * Merge two sorted arrays of integers.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12309362#overview
 */
public class MergeSortedArrays {
	public int[] merge(int[] left, int[] right) {
		int[] solution = new int[left.length + right.length];

		if (left.length == 0) {
			return right;
		} 
		if (right.length == 0) {
			return left;
		}
		
		int l = 0, r = 0, s = 0; 
		
		while(s < solution.length) {
			if(l == left.length) {
				solution[s] = right[r];
				r++;
			} else if(r == right.length) {
				solution[s] = left[l];
				l++;
			} else if(left[l] <= right[r]) {
				solution[s] = left[l];
				l++;
			} else if (right[r] < left[l]) {
				solution[s] = right[r];
				r++;
			}
			s++;	
		}
		
		return solution;
	}
}
