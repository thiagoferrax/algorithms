package com.trainings.algorithms.dynamicprogramming;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void test() {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        assertEquals(22, ks.solveKnapsack(profits, weights, 7));
        assertEquals(17, ks.solveKnapsack(profits, weights, 6));
    }

    @Test
    public void testBottomUpSolution() {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        assertEquals(22, ks.solveKnapsackBottomUpSolution(profits, weights, 7));
        assertEquals(17, ks.solveKnapsackBottomUpSolution(profits, weights, 6));
    }


}
