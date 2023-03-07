package com.trainings.algorithms.sorting;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CountingInversionsTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(2, 4, 1);
        assertEquals(2, CountingInversions.countInversions(list));
    }

    @Test
    public void test_11122() {
        List<Integer> list = Arrays.asList(1, 1, 1, 2, 2);
        assertEquals(0, CountingInversions.countInversions(list));
    }

    public void test_21312() {
        List<Integer> list = Arrays.asList(2, 1, 3, 1, 2);
        assertEquals(4, CountingInversions.countInversions(list));
    }

}
