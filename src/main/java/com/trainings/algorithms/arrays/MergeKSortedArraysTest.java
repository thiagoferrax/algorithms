package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

class MergeKSortedArraysTest {

    @Test
    void testHappyDay() {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                MergeKSortedArrays.mergeKArrays(new int[][]{{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}}));
    }

}
