package com.trainings.algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void testOne(){
        assertEquals(4, new BinarySearch().search(new int[]{-1,0,3,5,9,12}, 9));
    }
}