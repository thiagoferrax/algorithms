package com.trainings.algorithms.stacksandqueues;

/**
 * Implement a queue using stacks.
 */
public class MyQueueWithStacks<T> {
	
	private MyStackWithArray<T> stack1;
	private MyStackWithArray<T> stack2;

	public MyQueueWithStacks() {
		stack1 = new MyStackWithArray<T>();
		stack2 = new MyStackWithArray<T>();
	}
	
	public void push(T value) {
		stack1.push(value);
	}

	public Object length() {
		return stack1.length();
	}

	public Object pop() {
		if(stack1.peek() == null) {
			return null;
		}
		
		while(stack1.peek() != null) {
			stack2.push(stack1.pop());
		}
		
		T pop = stack2.pop();
		
		while(stack2.peek() != null) {
			stack1.push(stack2.pop());
		}
		
		return pop;
	}

	public T peek() {
		
		if(stack1.peek() == null) {
			return null;
		}
		
		while(stack1.peek() != null) {
			stack2.push(stack1.pop());
		}
		
		T peek = stack2.peek();
		
		while(stack2.peek() != null) {
			stack1.push(stack2.pop());
		}
		
		return peek;
	}

}
