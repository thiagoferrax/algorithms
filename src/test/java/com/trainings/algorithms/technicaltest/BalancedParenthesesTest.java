package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.Test;


public class BalancedParenthesesTest {

    @Test
    public void test() {
        Assert.assertTrue(BalancedParentheses.isBalanced("(())()()"));
        Assert.assertTrue(BalancedParentheses.isBalanced(""));
        Assert.assertTrue(BalancedParentheses.isBalanced("(()(())())"));
        Assert.assertFalse(BalancedParentheses.isBalanced("())"));
        Assert.assertFalse(BalancedParentheses.isBalanced("(((("));
        Assert.assertFalse(BalancedParentheses.isBalanced(")()("));
        Assert.assertTrue(BalancedParentheses.isBalanced("()(()((())))"));
    }

}
