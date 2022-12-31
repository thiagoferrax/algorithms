package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class MergeSortedArraysTest {

    @Test
    public void test() {
        MergeSortedArrays sortedArrays = new MergeSortedArrays();
        Assert.assertArrayEquals(new int[]{}, sortedArrays.merge(new int[]{}, new int[]{}));
        Assert.assertArrayEquals(new int[]{1}, sortedArrays.merge(new int[]{}, new int[]{1}));
        Assert.assertArrayEquals(new int[]{2, 3}, sortedArrays.merge(new int[]{2, 3}, new int[]{}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, sortedArrays.merge(new int[]{2, 3}, new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, sortedArrays.merge(new int[]{2, 3, 5, 7}, new int[]{1, 4, 6, 8}));
    }

}
