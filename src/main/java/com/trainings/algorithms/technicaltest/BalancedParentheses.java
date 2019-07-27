package com.trainings.algorithms.technicaltest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			String value = scan.next();

			System.out.println(isBalanced(value));
		}

		scan.close();
	}

	public static boolean isBalanced(String value) {
		int valueLength = value.length();

		if (valueLength == 0) { // S is empty
			return true;
		} else if (valueLength % 2 != 0) {
			// An odd number of brackets will never form a properly nested string.
			return false;
		} else if (valueLength >= 2 && (value.charAt(0) == ')' || value.charAt(valueLength - 1) == '(')) {
			// It will never start with ')' and finishes with '('
			return false;
		}

		Deque<Character> stack = new ArrayDeque<Character>();

		for (int n = 0; n < valueLength; n++) {
			switch (value.charAt(n)) {
			case '(':
				stack.push('(');
				break;
			case ')':
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else if (stack.isEmpty()) {
					return false;
				} else {
					stack.push(')');
				}
				break;
			default:
				return false;
			}
		}

		return stack.size() == 0;
	}
}
