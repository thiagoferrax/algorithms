package com.trainings.algorithms.prefixsums;

/**
 * Count the number of passing cars on the road.
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * Detected time complexity: O(N)
 */
public class PassingCars {
	public int solution(int[] A) {
        int N = A.length;
        
        int zeros = 0;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(A[i] == 0) {
                zeros++;   
            }
            count += zeros * A[i];
            
            if(count > 1000000000) {
            	return -1;
            }
        }
        
        return count;
    }
}
