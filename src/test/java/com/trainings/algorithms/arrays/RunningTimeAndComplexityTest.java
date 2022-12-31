package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class RunningTimeAndComplexityTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new String[]{"Not prime", "Prime", "Prime"},
                RunningTimeAndComplexity.isPrime(new int[]{12, 5, 7}));
        Assert.assertArrayEquals(
                new String[]{"Not prime", "Not prime", "Not prime", "Not prime", "Not prime", "Not prime",
                        "Not prime", "Not prime", "Not prime", "Not prime", "Not prime", "Not prime", "Not prime",
                        "Not prime", "Not prime", "Not prime", "Not prime", "Not prime", "Not prime"},
                RunningTimeAndComplexity.isPrime(new int[]{1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196,
                        225, 256, 289, 324, 361}));

    }

}
