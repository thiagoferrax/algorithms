package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;


public class MergeSortCountingInversionsTest {

    @Test
    public void test() {
        Assert.assertEquals(0, MergeSortCountingInversions.countInversions(new int[]{1, 1, 1, 2, 2}));
        //Assert.assertEquals(4, MergeSortCountingInversions.countInversions(new int[] {2, 1, 3, 1, 2}));
    }

}
