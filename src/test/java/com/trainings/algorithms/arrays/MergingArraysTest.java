package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MergingArraysTest {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        new MergingArrays().merge(nums1, 3, nums2, 3);

        assertEquals(Arrays.toString(new int[]{1, 2, 2, 3, 5, 6}), Arrays.toString(nums1));
    }

    @Test
    public void testTwo() {
        int[] nums1 = new int[]{1, 2, 3, 0};
        int[] nums2 = new int[]{2};

        new MergingArrays().merge(nums1, 3, nums2, 1);

        assertEquals(Arrays.toString(new int[]{1, 2, 2, 3}), Arrays.toString(nums1));
    }

}