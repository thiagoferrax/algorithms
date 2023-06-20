package com.trainings.algorithms.dynamicprogramming;

import java.math.BigInteger;

public class FibonacciModified {
    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger previous= BigInteger.valueOf(t1);
        BigInteger current = BigInteger.valueOf(t2);
        for (int i = 3; i <= n; i++) {
            BigInteger fibonacci = previous.add(current.pow(2));
            previous = current;
            current = fibonacci;
        }

        return current;
    }
}