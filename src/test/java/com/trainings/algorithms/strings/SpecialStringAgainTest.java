package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class SpecialStringAgainTest {

	@Test
	void testAA() {
		Assert.assertEquals(3, SpecialStringAgain.substrCount(2, "AA"));
	}

	@Test
	void testABA() {
		Assert.assertEquals(4, SpecialStringAgain.substrCount(3, "ABA"));
	}
	
	@Test
	void testasasd() {
		Assert.assertEquals(7, SpecialStringAgain.substrCount(5, "asasd"));
	}
	
	@Test
	void testaaaa() {
		Assert.assertEquals(10, SpecialStringAgain.substrCount(4, "aaaa"));
	}
	
	/*
	 * @Test void testaaaa2ndSolution() { Assert.assertEquals(10,
	 * SpecialStringAgain.substrCount2ndSolution(4, "aaaa")); }
	 */
	
	@Test
	void testisEspecial_aaaa() {
		Assert.assertEquals(true, SpecialStringAgain.isSpecial("aaaa"));
	}
	
	@Test
	void testisEspecial_aabaa() {
		Assert.assertEquals(true, SpecialStringAgain.isSpecial("aabaa"));
	}
	
	@Test
	void testisEspecial_bbabb() {
		Assert.assertEquals(true, SpecialStringAgain.isSpecial("bbabb"));
	}
	
	@Test
	void testisEspecial_cbbabbc() {
		Assert.assertEquals(false, SpecialStringAgain.isSpecial("cbbabbc"));
	}
	

}
