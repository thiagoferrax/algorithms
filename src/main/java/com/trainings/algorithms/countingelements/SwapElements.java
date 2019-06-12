package com.trainings.algorithms.countingelements;

/**
 * Check whether swapping one element of each array will result in equal sums of elements form each array.
 * Detected time complexity: O(N2))
 *
 */
public class SwapElements {
	public int solution(int[] A, int[] B, int m) {
		int length = A.length;
		
		
		//Sums of arrays
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < length; i++) {
			sumA += A[i];
			sumB += B[i];
		}		
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if(sumA - A[i] + B[j] == sumB + A[i] - B[j]) {					
					return 1;
				} 
			}
		}
		
		return 0;
	}
}
