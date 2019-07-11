package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BalancedParenthesesTest {

	@Test
	void test() {
		Assert.assertEquals(true, BalancedParentheses.isBalanced("(())()()"));
		Assert.assertEquals(true, BalancedParentheses.isBalanced(""));
		Assert.assertEquals(true, BalancedParentheses.isBalanced("(()(())())"));
		Assert.assertEquals(false, BalancedParentheses.isBalanced("())"));
		Assert.assertEquals(false, BalancedParentheses.isBalanced("(((("));
		Assert.assertEquals(false, BalancedParentheses.isBalanced(")()("));
		Assert.assertEquals(true, BalancedParentheses.isBalanced("()(()((())))"));
	}

}
