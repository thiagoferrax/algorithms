package com.trainings.algorithms.recursion;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void test() {
		Assert.assertEquals(1, Factorial.factorial(0));
		Assert.assertEquals(1, Factorial.factorial(1));
		Assert.assertEquals(2, Factorial.factorial(2));
		Assert.assertEquals(6, Factorial.factorial(3));
		Assert.assertEquals(24, Factorial.factorial(4));
		Assert.assertEquals(120, Factorial.factorial(5));
	}
	
	@Test
	void testFactorialIterative() {
		Assert.assertEquals(1, Factorial.factorialIterative(0));
		Assert.assertEquals(1, Factorial.factorialIterative(1));
		Assert.assertEquals(2, Factorial.factorialIterative(2));
		Assert.assertEquals(6, Factorial.factorialIterative(3));
		Assert.assertEquals(24, Factorial.factorialIterative(4));
		Assert.assertEquals(120, Factorial.factorialIterative(5));
	}

}
