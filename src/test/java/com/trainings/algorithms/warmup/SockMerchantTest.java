package com.trainings.algorithms.warmup;

import org.junit.Assert;
import org.junit.Test;


public class SockMerchantTest {

    @Test
    public void test() {
        Assert.assertEquals(3, SockMerchant.sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

}
