package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;


public class QuickSortTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{}, QuickSort.sort(new int[]{}));
        Assert.assertArrayEquals(new int[]{1}, QuickSort.sort(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2}, QuickSort.sort(new int[]{2, 1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, QuickSort.sort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, QuickSort.sort(new int[]{4, 3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 6, 7}, QuickSort.sort(new int[]{7, 4, 3, 5, 6, 6, 2, 1}));
    }

}
