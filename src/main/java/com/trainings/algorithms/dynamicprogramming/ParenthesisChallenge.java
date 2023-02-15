package com.trainings.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * @author Thiago
 */
public class ParenthesisChallenge {

	public List<String> generateParenthesis(int n) {
		List<String> parenthesisList = new ArrayList<>();
		if (n == 1) {
			parenthesisList.add("()");
		} else {
			generateParenthesis(n, 1, 0, "(", parenthesisList);
		}
		return parenthesisList;
	}

	private void generateParenthesis(int n, int left, int right, String current, List<String> parenthesisList) {
		if (left < n) {
			generateParenthesis(n, left + 1, right, current + "(", parenthesisList);
		}
		if (right < left && right < n) {
			generateParenthesis(n, left, right + 1, current + ")", parenthesisList);
		}
		boolean isFullPath = (left == n) && (right == n);
		if (isFullPath) {
			parenthesisList.add(current);
		}
	}
}
