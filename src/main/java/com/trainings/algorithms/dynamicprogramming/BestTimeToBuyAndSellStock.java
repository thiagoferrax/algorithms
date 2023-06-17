package com.trainings.algorithms.dynamicprogramming;

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


}
