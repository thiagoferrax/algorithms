package com.trainings.algorithms.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *  Determine whether a given string of parentheses (single type) is properly nested.
 *  https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 *  Detected time complexity: O(N) 
 */
public class Nesting {
	public int solution(String S) {
		int N = S.length();

		if (N == 0) { // S is empty
			return 1;
		} else if (N % 2 != 0) {
			// An odd number of brackets will never form a properly nested string.
			return 0;
		} else if (N >= 2 && (S.charAt(0) == ')' || S.charAt(N - 1) == '(')) {
			// It will never start with ')' and finishes with '('
			return 0;
		}

		Deque<Character> stack = new ArrayDeque<Character>();

		for (int n = 0; n < N; n++) {
			switch (S.charAt(n)) {
			case '(':
				stack.push('(');
				break;
			case ')':
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(')');
				}
				break;
			default:
				return 0;
			}
		}

		return stack.size() == 0 ? 1 : 0;
	}
}
