package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AnagramTest {

	@Test
	void test() {
		Assert.assertEquals(true, Anagram.isAnagram("AUTOR", "OUTRA"));
		Assert.assertEquals(false, Anagram.isAnagram("AUTOR", "OUTRORA"));
	}

}
