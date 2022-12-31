package com.trainings.algorithms.stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrangeTheBracketsTest {

    @Test
    public void testHappyDay() {
        assertTrue(ArrangeTheBrackets.isValid("{[><(])((}))"));
    }

    @Test
    public void testEdgeCaseTest() {
        assertFalse(ArrangeTheBrackets.isValid("{[><(])((}))]"));
    }

    @Test
    public void testEvenListShouldBeInvalid() {
        assertFalse(ArrangeTheBrackets.isValid("{[><(])((}))])"));
    }

    @Test
    public void testAnotherHappyDay() {
        assertTrue(ArrangeTheBrackets.isValid("{[><(])((})))("));
    }

    @Test
    public void testOrderHappyDay() {
        assertEquals("(({([<>])}))", ArrangeTheBrackets.order("{[><(])((}))"));
    }

}
