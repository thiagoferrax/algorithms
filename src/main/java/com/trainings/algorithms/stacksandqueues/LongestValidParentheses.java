package com.trainings.algorithms.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int longest = 0;

        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')', '(');

        Stack<Character> stack = new Stack<>();

        int count = 0;
        if (s != null && s.length() > 1) {
            // find the longest valid parentheses
            for (int i = 0; i < s.length(); i++) {
                char character = s.charAt(i);
                Character peek = !stack.isEmpty() ? stack.peek() : null;
                if (peek != null && peek == parenthesesMap.get(character)) {
                    stack.pop();
                    count += 2;
                    if (longest < count) {
                        longest = count;
                    }
                } else {
                    stack.push(character);
                }
            }
        }

        return longest;
    }
}
