package com.trainings.algorithms.lambdas;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void testLambdas() {
        Product product = new Product(3235.89, 0.13);
        Assert.assertEquals("R$3154.52", product.getTotalPrice());
    }

}
