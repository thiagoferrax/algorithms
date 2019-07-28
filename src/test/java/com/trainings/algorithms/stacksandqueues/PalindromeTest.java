package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PalindromeTest {

	@Test
	void test() {
		Assert.assertTrue(Palindrome.isPalindrome("Hannah"));
		Assert.assertTrue(Palindrome.isPalindrome("Ada"));
		Assert.assertTrue(Palindrome.isPalindrome("Nenonen"));
		Assert.assertFalse(Palindrome.isPalindrome("Thiago"));
	}

}
