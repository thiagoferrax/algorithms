package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

	@Test
	void test() {
		Assert.assertEquals("pea", LongestCommonPrefix.find(new String[] {"pea", "pear", "apple", "for", "april", "apendix", "peace"}));
		Assert.assertEquals("pearl", LongestCommonPrefix.find(new String[] {"pear", "pearl", "pearly", "apple", "for", "april", "apendix", "peace"}));
	}

}
