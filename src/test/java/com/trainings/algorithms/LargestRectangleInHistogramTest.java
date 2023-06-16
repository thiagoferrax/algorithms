package com.trainings.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleInHistogramTest {
    @Test
    public void example1() {
        assertEquals(10, new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        ;
    }
}