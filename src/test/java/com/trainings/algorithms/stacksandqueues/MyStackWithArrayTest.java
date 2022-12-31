package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;


public class MyStackWithArrayTest {

    @Test
    public void whenPushingFirstElementStackHasLenghtOne() {
        MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
        stack.push(1);
        Assert.assertEquals(1, stack.length());
    }

    @Test
    public void whenPopingInAStackWithOnlyOneElementShouldReturnIt() {
        MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
        stack.push(123);
        Assert.assertEquals(Integer.valueOf(123), stack.pop());
        Assert.assertEquals(0, stack.length());
    }

    @Test
    public void whenPopingInAStackWithSomeElementsShouldReturnTheLastAddedOne() {
        MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(2, stack.length());
    }

    @Test
    public void whenPopingInAnEmptyStackShouldReturnNull() {
        MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
        stack.push(1);
        stack.pop();
        Assert.assertNull(stack.pop());
    }

    @Test
    public void whenPeekingInAStackShouldReturnLastElementAndItShouldNotBeRemovedFromTheStack() {
        MyStackWithArray<Integer> stack = new MyStackWithArray<Integer>();
        stack.push(1);
        Assert.assertEquals(Integer.valueOf(1), stack.peek());
        Assert.assertEquals(1, stack.length());
    }
}
