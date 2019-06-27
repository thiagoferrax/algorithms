package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NestingTest {

	@Test
	void test() {
		Nesting nesting = new Nesting();
		
		Assert.assertEquals(1, nesting.solution(""));
		Assert.assertEquals(1, nesting.solution("(()(())())"));
		Assert.assertEquals(0, nesting.solution("())"));
		Assert.assertEquals(0, nesting.solution("(((("));
		Assert.assertEquals(0, nesting.solution(")()("));
		Assert.assertEquals(1, nesting.solution("()(()((())))"));
	}

}
