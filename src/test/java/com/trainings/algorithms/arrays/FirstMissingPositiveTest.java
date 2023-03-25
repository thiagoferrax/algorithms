package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class FirstMissingPositiveTest {

    @Test
    public void testOne() {
        Assert.assertEquals(3, new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(2, new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(1, new FirstMissingPositive().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    @Test
    public void testWithDuplicatedNumberInInput() {
        Assert.assertEquals(3, new FirstMissingPositive().firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
    }

}
