package com.trainings.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void example1(){
        assertEquals(5, new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    public void example2(){
        assertEquals(0, new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,6,4,3,1}));
    }

}