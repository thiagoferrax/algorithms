package com.trainings.algorithms.https;

import org.junit.Assert;
import org.junit.Test;


public class TransactionsByLocationAndIdTest {

    @Test
    public void test1() {
        Assert.assertEquals(-9001, Result.getTransactions(2, 8, 119, 212));

    }

    @Test
    public void test2() {
        Assert.assertEquals(12356, Result.getTransactions(4, 6, 100, 250));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-3081, Result.getTransactions(1, 9, 25, 75));
    }

    @Test
    public void test4() {
        Assert.assertEquals(-2957, Result.getTransactions(2, 8, 5, 50));
    }

    @Test
    public void test5() {
        Assert.assertEquals(-9472, Result.getTransactions(1, 9, 100, 220));
    }

    @Test
    public void test6() {
        Assert.assertEquals(-3081, Result.getTransactions(1, 9, 25, 75));
    }

}
