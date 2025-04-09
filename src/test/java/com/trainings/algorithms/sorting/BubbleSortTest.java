package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;


public class BubbleSortTest {

    @Test
    public void test() {
        Assert.assertEquals(0, BubbleSort.bubbleSort(new int[]{1, 2, 3}));
        Assert.assertEquals(1, BubbleSort.bubbleSort(new int[]{2, 1, 3}));
    }

    @Test
    public void test3rdSolution() {
        Assert.assertEquals(0, BubbleSort.bubbleSort3rdSolution(new int[]{1, 2, 3}));
        Assert.assertEquals(1, BubbleSort.bubbleSort3rdSolution(new int[]{2, 1, 3}));
        Assert.assertEquals(2, BubbleSort.bubbleSort3rdSolution(new int[]{4, 1, 3}));
        Assert.assertEquals(5, BubbleSort.bubbleSort3rdSolution(new int[]{4, 1, 3, 3, 5, 7, 4}));
        Assert.assertEquals(19, BubbleSort.bubbleSort3rdSolution(new int[]{7, 5, 4, 4, 3, 3, 1}));
        Assert.assertEquals(0, BubbleSort.bubbleSort3rdSolution(new int[]{1}));
        Assert.assertEquals(0, BubbleSort.bubbleSort3rdSolution(null));
    }

}
