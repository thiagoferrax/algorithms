package com.trainings.algorithms.recursion;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Calculate fibonacci with recursion and iteration.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12394680#content
 */
class FibonacciTest {

	@Test
	void test() {
		Assert.assertEquals(0, Fibonacci.fibonacci(0));
		Assert.assertEquals(1, Fibonacci.fibonacci(1));
		Assert.assertEquals(1, Fibonacci.fibonacci(2));
		Assert.assertEquals(2, Fibonacci.fibonacci(3));
		Assert.assertEquals(3, Fibonacci.fibonacci(4));
		Assert.assertEquals(5, Fibonacci.fibonacci(5));
		Assert.assertEquals(8, Fibonacci.fibonacci(6));
	}
	
	@Test
	void testFibonacciIterative() {
		Assert.assertEquals(0, Fibonacci.fibonacciIterative(0));
		Assert.assertEquals(1, Fibonacci.fibonacciIterative(1));
		Assert.assertEquals(1, Fibonacci.fibonacciIterative(2));
		Assert.assertEquals(2, Fibonacci.fibonacciIterative(3));
		Assert.assertEquals(3, Fibonacci.fibonacciIterative(4));
		Assert.assertEquals(5, Fibonacci.fibonacciIterative(5));
		Assert.assertEquals(8, Fibonacci.fibonacciIterative(6));
	}

}
