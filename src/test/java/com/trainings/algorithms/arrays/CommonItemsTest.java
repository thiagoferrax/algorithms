package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class CommonItemsTest {

    @Test
    public void test() {
        CommonItems commonItems = new CommonItems();
        Assert.assertTrue(commonItems.solution(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'x'}));
        Assert.assertFalse(commonItems.solution(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'i'}));
    }

    @Test
    public void testBruteForce() {
        CommonItems commonItems = new CommonItems();
        Assert.assertTrue(commonItems.bruteForceSolution(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'x'}));
        Assert.assertFalse(commonItems.bruteForceSolution(new char[]{'a', 'b', 'c', 'x'}, new char[]{'z', 'y', 'i'}));
    }
}
