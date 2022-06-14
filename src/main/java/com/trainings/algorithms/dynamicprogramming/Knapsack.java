package com.trainings.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/
public class Knapsack {

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {

		Map<String, Integer> memoization = new HashMap<>();

		return solveKnapsack(profits, weights, capacity, 0, memoization);
	}

	private int solveKnapsack(int[] profits, int[] weights, int capacity, int index, Map<String, Integer> memoization) {
		if (capacity <= 0 || index >= profits.length) {
			return 0;
		}
		String key = String.format("c=%d_i=%d", capacity, index);

		if (memoization.containsKey(key)) {
			return memoization.get(key);
		}

		int profitWithCurrentItem = weights[index] <= capacity
				? profits[index] + solveKnapsack(profits, weights, capacity - weights[index], index + 1, memoization)
				: 0;

		int profitWithoutCurrentItem = solveKnapsack(profits, weights, capacity, index + 1, memoization);

		int max = Math.max(profitWithCurrentItem, profitWithoutCurrentItem);

		memoization.put(key, max);

		return max;
	}

}
