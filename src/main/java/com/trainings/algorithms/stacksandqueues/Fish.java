package com.trainings.algorithms.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * N voracious fish are moving along a river. Calculate how many fish are alive.
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 */
public class Fish {
	public int solution(int[] A, int[] B) {
		int N = A.length;

		Deque<Integer> stack = new ArrayDeque<>();

		int currentFlow = B[0];
		for (int b = 0; b < N; b++) {
			int fishFlow = B[b];
			int fishSize = A[b];
			
			if (currentFlow <= fishFlow) {
				stack.push(fishSize);
				currentFlow = fishFlow;
			} else if (!stack.isEmpty() && stack.peek() < fishSize) {
				stack.pop();
				stack.push(fishSize);
				currentFlow = fishFlow;
			}
		}

		return stack.size();
	}
}
