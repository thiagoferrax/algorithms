package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BracketsTest {

	@Test
	void test() {
		Brackets brackets = new Brackets();
		Assert.assertEquals(1, brackets.solution("{[()()]}"));
		Assert.assertEquals(0, brackets.solution("([)()]"));
		Assert.assertEquals(0, brackets.solution(")("));
		Assert.assertEquals(0, brackets.solution("{{{{"));
	}

}
