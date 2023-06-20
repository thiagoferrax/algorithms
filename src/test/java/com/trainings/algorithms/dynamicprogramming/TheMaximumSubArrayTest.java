package com.trainings.algorithms.dynamicprogramming;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TheMaximumSubArrayTest {
    @Test
    public void example1(){
        assertEquals(List.of(16, 20), TheMaximumSubArray.maxSubarray(List.of(-1, 2, 3, -4, 5, 10)));
    }

    @Test
    public void example2(){
        assertEquals(List.of(-1, -1), TheMaximumSubArray.maxSubarray(List.of(-1, -2, -3, -4, -5, -10)));
    }

}