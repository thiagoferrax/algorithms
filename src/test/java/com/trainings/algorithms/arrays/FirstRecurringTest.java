package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FirstRecurringTest {

    @Test
    public void whenPassingANullOrEmptyArrayReturnsNull() {
        FirstRecurring firstRecurring = new FirstRecurring();
        Assert.assertNull(firstRecurring.getFirstRecurring(null));
        Assert.assertNull(firstRecurring.getFirstRecurring(new int[]{}));
    }

    public void whenPassingANotEmptyArrayWithARecurringValueReturnsIt() {
        FirstRecurring firstRecurring = new FirstRecurring();
        Assert.assertEquals(Integer.valueOf(2), firstRecurring.getFirstRecurring(new int[]{2, 5, 1, 2, 3}));
    }

}
