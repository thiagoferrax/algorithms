package com.trainings.algorithms.arrays;

import java.util.List;

public class MaximumProfit {

    public Long maximumProfit(List<Long> prices) {
        long min = prices.get(0);
        long max = 0L;
        for (int i = 0, j = 5; i < prices.size() - 5; i++, j++) {
            min = Math.min(min, prices.get(i));
            max = Math.max(max, prices.get(j));
        }
        return max - min;
    }

    public Long maximumProfit1stSolution(List<Long> prices) {
        // Brute force O(n^2)
        long maxProfit = 0;
        for (int i = 0; i < prices.size() - 5; i++) {
            for (int j = i+5; j < prices.size(); j++) {
                long profit = prices.get(j) - prices.get(i);
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

}
