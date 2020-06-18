package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class EncodeTest {

	@Test
	void testHappyDay() {
		Assert.assertEquals("3A4B4C8D", new Encode().execute("AAABBBBCCCCDDDDDDDD"));
	}
	
	@Test
	void testEmptyString() {
		Assert.assertEquals("", new Encode().execute(""));
	}

	
	@Test
	void testWithJustOneCharacter() {
		Assert.assertEquals("1A", new Encode().execute("A"));
	}
	
	@Test
	void testWithOneTypeCharacterManyTimes() {
		Assert.assertEquals("8A", new Encode().execute("AAAAAAAA"));
	}
	
	@Test
	void testWithNullString() {
		Assert.assertEquals("", new Encode().execute(null));
	}
}
