package com.trainings.algorithms.stacksandqueues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrangeTheBracketsTest {

	@Test
	void testHappyDay() {
		assertEquals(true, ArrangeTheBrackets.isValid("{[><(])((}))"));
	}

	@Test
	void testEdgeCaseTest() {
		assertEquals(false, ArrangeTheBrackets.isValid("{[><(])((}))]"));
	}

	@Test
	void testEvenListShouldBeInvalid() {
		assertEquals(false, ArrangeTheBrackets.isValid("{[><(])((}))])"));
	}

	@Test
	void testAnotherHappyDay() {
		assertEquals(true, ArrangeTheBrackets.isValid("{[><(])((})))("));
	}

	@Test
	void testOrderHappyDay() {
		assertEquals("(({([<>])}))", ArrangeTheBrackets.order("{[><(])((}))"));
	}

}
