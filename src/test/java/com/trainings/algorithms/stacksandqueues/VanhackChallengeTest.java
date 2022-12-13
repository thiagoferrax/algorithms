package com.trainings.algorithms.stacksandqueues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VanhackChallengeTest {

	@Test
	void testHappyDay() {
		assertEquals(true, VanhackChallenge.isValid("{[><(])((}))"));
	}
	
	@Test
	void testEdgeCaseTest() {
		assertEquals(false, VanhackChallenge.isValid("{[><(])((}))]"));
	}
	
	@Test
	void testEvenListShouldBeInvalid() {
		assertEquals(false, VanhackChallenge.isValid("{[><(])((}))])"));
	}
	
	@Test
	void testAnotherHappyDay() {
		assertEquals(true, VanhackChallenge.isValid("{[><(])((})))("));
	}
	
	@Test
	void testOrderHappyDay() {
		assertEquals("(({([<>])}))", VanhackChallenge.order("{[><(])((}))"));
	}


}
