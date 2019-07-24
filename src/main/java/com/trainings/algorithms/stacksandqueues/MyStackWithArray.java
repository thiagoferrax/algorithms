package com.trainings.algorithms.stacksandqueues;

/**
 * Implementing a MyStack using a static array and increasing it when needed.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12334316#content
 */
public class MyStackWithArray<T> {
	private static final int INCREASE_FACTOR = 2;
	private static final int INITIAL_SIZE = 100;

	private int increaseFactor = INCREASE_FACTOR;
	private int stackSize = INITIAL_SIZE;

	@SuppressWarnings("unchecked")
	private T[] data = (T[]) new Object[INITIAL_SIZE];

	private int length;

	public void push(T value) {
		increaseDataSizeIfNeeded();

		data[this.length] = value;
		this.length++;
	}

	@SuppressWarnings("unchecked")
	private void increaseDataSizeIfNeeded() {
		if (this.length == this.stackSize) {
			this.stackSize = this.increaseFactor * INITIAL_SIZE;

			T[] newData = (T[]) new Object[this.stackSize];
			this.increaseFactor++;

			for (int d = 0; d < data.length; d++) {
				newData[d] = data[d];
			}

			data = newData;
		}
	}

	public int length() {
		return length;
	}

	public T pop() {
		if (this.length == 0) {
			return null;
		}

		T popped = data[this.length - 1];
		data[this.length - 1] = null;
		this.length--;
		return popped;
	}

	public T peek() {
		if (this.length == 0) {
			return null;
		}

		return data[this.length - 1];
	}

}
