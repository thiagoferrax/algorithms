package com.trainings.algorithms.warmup;

import org.junit.Assert;
import org.junit.Test;


public class JumpingOnTheCloudsTest {

    @Test
    public void test() {
        Assert.assertEquals(4, JumpingOnTheClouds.jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
        Assert.assertEquals(3, JumpingOnTheClouds.jumpingOnClouds(new int[]{0, 1, 0, 0, 0, 1, 0}));
        Assert.assertEquals(0, JumpingOnTheClouds.jumpingOnClouds(new int[]{0}));
        Assert.assertEquals(3, JumpingOnTheClouds.jumpingOnClouds(new int[]{0, 0, 0, 0, 0, 0}));
    }

}
