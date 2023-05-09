package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMinimumInRotatedSortedArrayIITest {
    @Test
    public void example1(){
        assertEquals(1, new FindMinimumInRotatedSortedArrayII().findMin(new int[]{1,3,5}));
    }

    @Test
    public void example2(){
        assertEquals(0, new FindMinimumInRotatedSortedArrayII().findMin(new int[]{2,2,2,0,1}));
    }
}