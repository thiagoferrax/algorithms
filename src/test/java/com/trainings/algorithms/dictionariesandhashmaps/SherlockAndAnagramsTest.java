package com.trainings.algorithms.dictionariesandhashmaps;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SherlockAndAnagramsTest {

	@Test
	void test() {
		Assert.assertEquals(2, SherlockAndAnagrams.sherlockAndAnagrams("mom"));
		Assert.assertEquals(4, SherlockAndAnagrams.sherlockAndAnagrams("abba"));
		Assert.assertEquals(0, SherlockAndAnagrams.sherlockAndAnagrams("abcd"));
		Assert.assertEquals(10, SherlockAndAnagrams.sherlockAndAnagrams("kkkk"));
	}

}
