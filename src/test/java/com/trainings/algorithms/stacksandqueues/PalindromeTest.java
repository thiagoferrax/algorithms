package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;


public class PalindromeTest {

    @Test
    public void test() {
        Assert.assertTrue(Palindrome.isPalindrome("Hannah"));
        Assert.assertTrue(Palindrome.isPalindrome("Ada"));
        Assert.assertTrue(Palindrome.isPalindrome("Nenonen"));
        Assert.assertFalse(Palindrome.isPalindrome("Thiago"));
    }

}
