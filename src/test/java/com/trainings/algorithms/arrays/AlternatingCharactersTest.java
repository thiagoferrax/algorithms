package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class AlternatingCharactersTest {

	@Test
	void testHappyDay() {
		Assert.assertEquals(4, AlternatingCharacters.alternatingCharacters("AAABABBABBAB"));
	}

}
