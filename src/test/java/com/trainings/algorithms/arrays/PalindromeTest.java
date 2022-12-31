package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class PalindromeTest {

    @Test
    public void test() {
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.isPalindrome("Hannah"));
        Assert.assertTrue(palindrome.isPalindrome("Ada"));
        Assert.assertTrue(palindrome.isPalindrome("Nenonen"));
        Assert.assertFalse(palindrome.isPalindrome("Thiago"));
    }

}
