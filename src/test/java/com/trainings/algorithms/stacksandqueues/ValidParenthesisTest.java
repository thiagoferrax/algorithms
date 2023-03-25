package com.trainings.algorithms.stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidParenthesisTest {
    @Test
    public void testOne() {
        assertEquals(true, new ValidParenthesis().isValid("()"));
    }
}