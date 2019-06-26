package com.trainings.algorithms.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Determine whether a given string of parentheses (multiple types) is properly
 * nested. 
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * Detected time complexity: O(N)
 */
public class Brackets {
	public int solution(String S) {
		int N = S.length();

		Deque<Character> stack = new ArrayDeque<Character>();

		for (int n = 0; n < N; n++) {
			switch (S.charAt(n)) {
			case '(':
				stack.push('(');
				break;
			case '{':
				stack.push('{');
				break;
			case '[':
				stack.push('[');
				break;
			case ']':
				if (pop(stack, '[') == 0) {
					return 0;
				}
				break;
			case '}':
				if (pop(stack, '{') == 0) {
					return 0;
				}
				break;
			case ')':
				if (pop(stack, '(') == 0) {
					return 0;
				}
				break;
			default:
				return 0;
			}
		}
		return stack.size() == 0 ? 1 : 0;
	}

	private int pop(Deque<Character> stack, char character) {
		if (stack.isEmpty() || character != stack.peek()) {
			return 0;
		}

		stack.pop();
		return 1;
	}
}
