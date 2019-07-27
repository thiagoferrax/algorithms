package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AnagramTest {

	@Test
	void test() {
		Assert.assertEquals(true, Anagram.isAnagram("AUTHOR", "OUTRHA"));
		Assert.assertEquals(false, Anagram.isAnagram("AUTHOR", "OUTRORA"));
		Assert.assertEquals(true, Anagram.isAnagram("BETTER", "RETTEB"));
	}

}
