package com.trainings.algorithms.dynamicprogramming;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FibonacciModifiedTest {
    @Test
    public void example1(){
        assertEquals(BigInteger.valueOf(27), FibonacciModified.fibonacciModified(0,1,6));
    }
}