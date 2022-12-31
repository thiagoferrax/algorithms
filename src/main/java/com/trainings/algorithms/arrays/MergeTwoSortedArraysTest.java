package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

class MergeTwoSortedArraysTest {

    @Test
    void test() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5, 6, 8},
                MergeTwoSortedArrays.mergeArrays(new int[]{1, 3, 4, 5}, new int[]{2, 4, 6, 8}, 4, 4));
    }

    @Test
    void testWithLimit() {
        assertArrayEquals(new int[]{1, 2, 3},
                MergeTwoSortedArrays.mergeArrays(new int[]{1, 3, 4, 5}, new int[]{2, 4, 6, 8}, 3));
    }

    @Test
    void testWithLimitUsingStreams() {
        assertArrayEquals(new int[]{1, 2, 3},
                MergeTwoSortedArrays.mergeArrays2ndSolution(new int[]{1, 3, 4, 5}, new int[]{2, 4, 6, 8}, 3));
    }

}
