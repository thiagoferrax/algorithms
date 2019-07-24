package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyStackWithArrayTest {

	@Test
	void whenPushingFirstElementStackHasLenghtOne() {
		MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
		stack.push(1);
		Assert.assertEquals(1, stack.length());
	}

	@Test
	void whenPopingInAStackWithOnlyOneElementShouldReturnIt() {
		MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
		stack.push(123);
		Assert.assertEquals(Integer.valueOf(123), stack.pop());
		Assert.assertEquals(0, stack.length());
	}

	@Test
	void whenPopingInAStackWithSomeElementsShouldReturnTheLastAddedOne() {
		MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Assert.assertEquals(Integer.valueOf(3), stack.pop());
		Assert.assertEquals(2, stack.length());
	}

	@Test
	void whenPopingInAnEmptyStackShouldReturnNull() {
		MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
		stack.push(1);
		stack.pop();
		Assert.assertNull(stack.pop());
	}

	@Test
	void whenPeekingInAStackShouldReturnLastElementAndItShouldNotBeRemovedFromTheStack() {
		MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
		stack.push(1);
		Assert.assertEquals(Integer.valueOf(1), stack.peek());
		Assert.assertEquals(1, stack.length());
	}
}
