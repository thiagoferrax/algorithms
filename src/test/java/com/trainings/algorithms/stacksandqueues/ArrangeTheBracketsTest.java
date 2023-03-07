package com.trainings.algorithms.stacksandqueues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
