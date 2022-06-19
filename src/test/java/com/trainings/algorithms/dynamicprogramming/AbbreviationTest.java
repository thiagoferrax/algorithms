package com.trainings.algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AbbreviationTest {

	@Test
	void testHappyDay() {
		assertEquals("YES", Abbreviation.abbreviation("AbcDE", "ABDE"));
	}
	

	@Test
	void test_beFgH_EFG() {
		assertEquals("NO", Abbreviation.abbreviation("beFgH", "EFG"));
	}


}
