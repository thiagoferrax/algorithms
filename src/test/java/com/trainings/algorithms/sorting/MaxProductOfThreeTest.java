package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaxProductOfThreeTest {

	@Test
	void test() {
		MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
		Assert.assertEquals(60, maxProductOfThree.solution(new int[] {-3, 1, 2, -1, 5, 6}));
		Assert.assertEquals(-6, maxProductOfThree.solution(new int[] {-3, 1, 2}));
	}

}
