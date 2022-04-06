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

}
