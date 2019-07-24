package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyQueueTest {

	@Test
	void whenPushingElementInAnEmptyQueueResultingLengthIsOne() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.push(1);

		Assert.assertEquals(1, queue.length());
	}

	@Test
	void whenPopingElementInAnEmptyQueueShouldReturnNull() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		Assert.assertNull(queue.pop());
	}

	@Test
	void whenPopingElementInANotEmptyQueueShouldReturnFirstValueAdded() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		Assert.assertEquals(Integer.valueOf(1), queue.pop());
		Assert.assertEquals(Integer.valueOf(2), queue.pop());
		Assert.assertEquals(Integer.valueOf(3), queue.pop());
	}

	@Test
	void whenPeekingElementInAnEmptyQueueShouldReturnNull() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		Assert.assertNull(queue.peek());
	}

	@Test
	void whenPeekingElementInANotEmptyQueueShouldReturnFirstValueAdded() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		Assert.assertEquals(Integer.valueOf(1), queue.peek());
		Assert.assertEquals(3, queue.length());
	}

}
