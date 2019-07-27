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
		int answer = 1;
		
		if(n < 2) {
			return answer;
		}
		
		for (int i = 2; i <= n; i++) {
			answer *= i;
		}
		
		return answer;
	}

}
