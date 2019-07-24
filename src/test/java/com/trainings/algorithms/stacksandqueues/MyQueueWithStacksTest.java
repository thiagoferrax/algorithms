package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyQueueWithStacksTest {

	@Test
	void whenPushingElementInAnEmptyQueueResultingLengthIsOne() {
		MyQueueWithStacks<Integer> queue = new MyQueueWithStacks<Integer>();
		queue.push(1);

		Assert.assertEquals(1, queue.length());
	}

	@Test
	void whenPopingElementInAnEmptyQueueShouldReturnNull() {
		MyQueueWithStacks<Integer> queue = new MyQueueWithStacks<Integer>();
		Assert.assertNull(queue.pop());
	}

	@Test
	void whenPopingElementInANotEmptyQueueShouldReturnFirstValueAdded() {
		MyQueueWithStacks<Integer> queue = new MyQueueWithStacks<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		Assert.assertEquals(Integer.valueOf(1), queue.pop());
		Assert.assertEquals(Integer.valueOf(2), queue.pop());
		Assert.assertEquals(Integer.valueOf(3), queue.pop());
	}

	@Test
	void whenPeekingElementInAnEmptyQueueShouldReturnNull() {
		MyQueueWithStacks<Integer> queue = new MyQueueWithStacks<Integer>();
		Assert.assertNull(queue.peek());
	}

	@Test
	void whenPeekingElementInANotEmptyQueueShouldReturnFirstValueAdded() {
		MyQueueWithStacks<Integer> queue = new MyQueueWithStacks<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		Assert.assertEquals(Integer.valueOf(1), queue.peek());
		Assert.assertEquals(3, queue.length());
	}

}
