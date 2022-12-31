package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class PairsEqualTotalTest {

    @Test
    public void testBruteForce() {
        PairsEqualTotal pairsEqualTotal = new PairsEqualTotal();

        Assert.assertFalse(pairsEqualTotal.hasPairsThatSumEqualsTotalBruteForce(new int[]{1, 2, 3, 9}, 8));
        Assert.assertTrue(pairsEqualTotal.hasPairsThatSumEqualsTotalBruteForce(new int[]{1, 2, 4, 4}, 8));
    }

    @Test
    public void test() {
        PairsEqualTotal pairsEqualTotal = new PairsEqualTotal();

        Assert.assertFalse(pairsEqualTotal.hasPairsThatSumEqualsTotal(new int[]{1, 2, 3, 9}, 8));
        Assert.assertTrue(pairsEqualTotal.hasPairsThatSumEqualsTotal(new int[]{1, 2, 4, 4}, 8));
    }

}
