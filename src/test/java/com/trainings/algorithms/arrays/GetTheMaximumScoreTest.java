package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetTheMaximumScoreTest {
    @Test
    public void example1() {
        assertEquals(30, new GetTheMaximumScore().maxSum(new int[]{2,4,5,8,10}, new int[]{4,6,8,9}));
    }

    //@Test
    public void example2() {
        assertEquals(0, new GetTheMaximumScore().maxSum(new int[]{6,7,12,13,14,17,20}, new int[]{1,4,5,7}));
    }


}