package com.trainings.algorithms.stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/">longest-valid-parentheses</a>
 */
public class LongestValidParenthesesTest {


    @Test
    public void testOne() {
        assertEquals(2, new LongestValidParentheses().longestValidParentheses("(()"));
    }

    @Test
    public void testTwo() {
        assertEquals(4, new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    @Test
    public void testThree() {
        assertEquals(0, new LongestValidParentheses().longestValidParentheses(""));
    }
}