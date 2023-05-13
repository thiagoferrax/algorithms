package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainerWithMostWaterTest {

    @Test
    public void testOne(){
        assertEquals(49, new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    public void testTwo(){
        assertEquals(1, new ContainerWithMostWater().maxArea(new int[]{1,1}));
    }

}