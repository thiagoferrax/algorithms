package com.trainings.algorithms.recursion;

/*
 * Calculate factorial using recursion and iteration.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12394024#content
 */
public class Factorial {

	public static int factorial(int n) {
		if(n < 2) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static int factorialIterative(int n) {
		int[] factorials = new int[n+1];
		factorials[0] = 1;
	
		for (int i = 1; i < factorials.length; i++) {
			factorials[i] = i * factorials[i - 1];
		}
		
		return factorials[n];
	}

}
