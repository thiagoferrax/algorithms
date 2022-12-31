package com.trainings.algorithms.warmup;

import org.junit.Assert;
import org.junit.Test;


public class CountingValleysTest {

    @Test
    public void test() {
        Assert.assertEquals(1, CountingValleys.countingValleys(8, "UDDDUDUU"));
        Assert.assertEquals(4, CountingValleys.countingValleys(8, "DUDUDUDU"));
        Assert.assertEquals(1, CountingValleys.countingValleys(8, "DDDDUUUU"));
    }

}
