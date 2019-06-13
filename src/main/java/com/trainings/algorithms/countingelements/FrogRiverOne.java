package com.trainings.algorithms.countingelements;

/*
 * Find the earliest time when a frog can jump to the other side of a river.
 * Detected time complexity: O(N)
 */
public class FrogRiverOne {
	public int solution(int X, int[] A) {

		int length = A.length;

		int[] leavesBeforeX = new int[X];
		for (int x = 0; x < leavesBeforeX.length; x++) {
			leavesBeforeX[x] = 0;
		}
		
		int paSum = ((1 + X) * (X)) / 2;
		
		int sum = 0;
		for (int k = 0; k < length; k++) {
			if (A[k] <= X) {
				if(leavesBeforeX[A[k]-1] == 0) {
					leavesBeforeX[A[k]-1] = 1;	
					sum += A[k];
					
					if(sum == paSum) {
						return k;
					}
				}
			}
		}

		return -1;
	}
}
