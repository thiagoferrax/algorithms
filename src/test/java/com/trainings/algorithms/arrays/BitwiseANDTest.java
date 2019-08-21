package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BitwiseANDTest {

	@Test
	void test() {
		Assert.assertEquals(1, BitwiseAND.getMaximumBitwiseAnd(5, 2));
		Assert.assertEquals(4, BitwiseAND.getMaximumBitwiseAnd(8, 5));
		Assert.assertEquals(0, BitwiseAND.getMaximumBitwiseAnd(2, 2));
	}

}
