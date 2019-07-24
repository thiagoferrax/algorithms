package com.trainings.algorithms.stacksandqueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implement a queue using a LinkedList.
 */
public class MyQueue<T> {

	private LinkedList<T> data;

	public MyQueue() {
		data = new LinkedList<T>();
	}

	public void push(T value) {
		data.push(value);
	}

	public int length() {
		return data.size();
	}

	public T pop() {
		return data.pollLast();
	}

	public T peek() {
		T last;
		try {
			last = data.getLast();
		} catch (NoSuchElementException e) {
			last = null;
		}

		return last;
	}

}
