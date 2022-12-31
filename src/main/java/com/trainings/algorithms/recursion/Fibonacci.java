package com.trainings.algorithms.recursion;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int[] fibonaccis = new int[Math.max(2, n + 1)];
        fibonaccis[0] = 0;
        fibonaccis[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonaccis[i] = fibonaccis[i - 1] + fibonaccis[i - 2];
        }

        return fibonaccis[n];
    }

}
