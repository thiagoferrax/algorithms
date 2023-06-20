package com.trainings.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciModifiedTest {
    @Test
    public void example1(){
        assertEquals(27, FibonacciModified.fibonacciModified(0,1,6));
    }
}