package com.trainings.algorithms.technicaltest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxEventsTest {

    @Test
    public void test() {
        Assert.assertEquals(3, ResultMaxEvents.maxEvents(Arrays.asList(1, 3, 5), Arrays.asList(2, 2, 2)));
        Assert.assertEquals(3, ResultMaxEvents.maxEvents(Arrays.asList(1, 1, 1, 1, 5), Arrays.asList(10, 3, 1, 4, 2)));
        Assert.assertEquals(4, ResultMaxEvents.maxEvents(Arrays.asList(1, 1, 1, 1), Arrays.asList(10, 3, 1, 4)));
        Assert.assertEquals(2, ResultMaxEvents.maxEvents(Arrays.asList(1, 3, 5, 7), Arrays.asList(12, 2, 2, 2)));
        Assert.assertEquals(4, ResultMaxEvents.maxEvents(Arrays.asList(1, 3, 5, 7), Arrays.asList(1, 3, 1, 4)));
    }

}
