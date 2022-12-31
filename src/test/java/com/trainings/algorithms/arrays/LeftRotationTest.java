package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class LeftRotationTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{3, 4, 5, 1, 2}, LeftRotation.rotLeft(new int[]{1, 2, 3, 4, 5}, 2));
        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 1}, LeftRotation.rotLeft(new int[]{1, 2, 3, 4, 5}, 6));
        Assert.assertArrayEquals(new int[]{2}, LeftRotation.rotLeft(new int[]{2}, 10));
    }

}
