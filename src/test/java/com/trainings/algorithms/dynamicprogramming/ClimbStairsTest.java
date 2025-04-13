package com.trainings.algorithms.dynamicprogramming;

import junit.framework.TestCase;

public class ClimbStairsTest extends TestCase {

    public void testClimbStairs() {
        assertEquals(1, new ClimbStairs().climbStairs(1));
        assertEquals(2, new ClimbStairs().climbStairs(2));
        assertEquals(3, new ClimbStairs().climbStairs(3));
    }

}