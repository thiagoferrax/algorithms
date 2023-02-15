package com.trainings.algorithms.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesisChallengeTest {

	@Test
	public void test() {
		Assert.assertEquals("[((())), (()()), (())(), ()(()), ()()()]", new ParenthesisChallenge().generateParenthesis(3).toString());
	}

}
