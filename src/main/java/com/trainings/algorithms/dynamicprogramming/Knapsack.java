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

    public int solveKnapsackBottomUpSolution(int[] profits, int[] weights, int capacity) {
        // Basic checks
        int n = profits.length;
        if (capacity <= 0 || n == 0 || weights.length == 0 || n != weights.length) {
            return 0;
        }

        int[][] dp = new int[n][capacity + 1];

        // Populate the capacity 0 as profit 0
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // Populate for the first weight its profit if that weight is less than or
        // equals the current capacity.
        for (int c = 1; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 0; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }

                profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }

}
