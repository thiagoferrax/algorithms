package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;


public class MyQueueTest {

    @Test
    public void whenPushingElementInAnEmptyQueueResultingLengthIsOne() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.push(1);

        Assert.assertEquals(1, queue.length());
    }

    @Test
    public void whenPopingElementInAnEmptyQueueShouldReturnNull() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Assert.assertNull(queue.pop());
    }

    @Test
    public void whenPopingElementInANotEmptyQueueShouldReturnFirstValueAdded() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assert.assertEquals(Integer.valueOf(1), queue.pop());
        Assert.assertEquals(Integer.valueOf(2), queue.pop());
        Assert.assertEquals(Integer.valueOf(3), queue.pop());
    }

    @Test
    public void whenPeekingElementInAnEmptyQueueShouldReturnNull() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Assert.assertNull(queue.peek());
    }

    @Test
    public void whenPeekingElementInANotEmptyQueueShouldReturnFirstValueAdded() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assert.assertEquals(Integer.valueOf(1), queue.peek());
        Assert.assertEquals(3, queue.length());
    }

}
