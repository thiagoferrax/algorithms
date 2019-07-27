package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PalindromeTest {

	@Test
	void test() {
		Palindrome palindrome = new Palindrome();
		Assert.assertTrue(palindrome.isPalindrome("Hannah"));
		Assert.assertTrue(palindrome.isPalindrome("Ada"));
		Assert.assertTrue(palindrome.isPalindrome("Nenonen"));
		Assert.assertFalse(palindrome.isPalindrome("Thiago"));
	}

}
