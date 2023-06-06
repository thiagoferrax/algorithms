package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfTwoIntegersTest {
    @Test
    public void exampleOne() {
        assertEquals(7, new SumOfTwoIntegers().getSum(3, 4));
    }

    @Test
    public void exampleTwo() {
        assertEquals(50, new SumOfTwoIntegers().getSum(20, 30));
    }

    @Test
    public void exampleThree() {
        assertEquals(5, new SumOfTwoIntegers().getSum(2, 3));
    }
}