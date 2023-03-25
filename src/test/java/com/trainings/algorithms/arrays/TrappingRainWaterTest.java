package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void testOne() {
        Assert.assertEquals(6, new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(9, new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

}
