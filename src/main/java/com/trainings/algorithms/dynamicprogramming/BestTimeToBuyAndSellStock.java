package com.trainings.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minToBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minToBuy = Math.min(minToBuy, prices[i - 1]);
            maxProfit = Math.max(maxProfit, prices[i] - minToBuy);
        }
        return maxProfit;
    }

    public int maxProfit1stSolution(int[] prices) {
        int maxProfit = 0;
        // Iterate throughout the prices and compare all the possibilities to get the maximum.
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfit3rdSolution(int[] prices) {
        Map<Integer, Integer> memoization = new HashMap<>();
        return max(prices, prices.length-1, memoization);
    }

    private int max(int[] prices, int n, Map<Integer, Integer> memoization) {
        if(n == 0) {
            return 0;
        } else if(memoization.containsKey(n)) {
            return memoization.get(n);
        } else {
            int max = Math.max(max(prices, n-1, memoization), max(prices, n));
            memoization.put(n, max);
            return max;
        }
    }

    private int max(int[] prices, int n) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, prices[n] - prices[i]);
        }
        return max;
    }
}
