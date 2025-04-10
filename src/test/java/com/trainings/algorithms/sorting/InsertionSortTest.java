package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;


public class InsertionSortTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{}, InsertionSort.sort(new int[]{}));
        Assert.assertArrayEquals(new int[]{1}, InsertionSort.sort(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, InsertionSort.sort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 5, 8}, InsertionSort.sort(new int[]{3, 2, 5, 3, 8, 1}));
    }

    @Test
    public void testInsertionSort() {
        Assert.assertArrayEquals(new int[]{}, InsertionSort.insertionSort(new int[]{}));
        Assert.assertArrayEquals(new int[]{1}, InsertionSort.insertionSort(new int[]{1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, InsertionSort.insertionSort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 5, 8}, InsertionSort.insertionSort(new int[]{3, 2, 5, 3, 8, 1}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, InsertionSort.insertionSort(new int[]{5, 6, 3, 1, 8, 7, 2, 4}));
    }

}
