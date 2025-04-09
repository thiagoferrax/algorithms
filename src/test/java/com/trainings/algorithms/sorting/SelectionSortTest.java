package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;


public class SelectionSortTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{}, SelectionSort.sort(new int[]{}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, SelectionSort.sort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{-3, -1, 2}, SelectionSort.sort(new int[]{-3, 2, -1}));
        Assert.assertArrayEquals(new int[]{1}, SelectionSort.sort(new int[]{1}));
    }

    @Test
    public void testSelectionSort() {
        Assert.assertArrayEquals(new int[]{}, SelectionSort.selectionSort(new int[]{}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, SelectionSort.selectionSort(new int[]{3, 2, 1}));
        Assert.assertArrayEquals(new int[]{-3, -1, 2}, SelectionSort.selectionSort(new int[]{-3, 2, -1}));
        Assert.assertArrayEquals(new int[]{1}, SelectionSort.selectionSort(new int[]{1}));
    }

}
