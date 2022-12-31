package com.trainings.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class MedianOfTwoSortedArraysTest {

    @Test
    void testHappyDay() {
        assertEquals(2.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    @Test
    void testSecondHappyDay() {
        assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
