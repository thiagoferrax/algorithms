package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MaximumProfitTest {

    @Test
    public void exampleOne(){
    assertEquals(Long.valueOf(999), new MaximumProfit().maximumProfit(List.of(1L, 2L, 3L, 5L, 6L, 7L, 8L,1000L, 10L)));
    }

}