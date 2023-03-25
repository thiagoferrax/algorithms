package com.trainings.algorithms.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">...</a>
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put(')', '(');
        parenthesisMap.put('}', '{');
        parenthesisMap.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c:
             chars) {
            if(!stack.isEmpty() && stack.peek() == parenthesisMap.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
