package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MinimumSwaps2Test {

	@Test
	void test() {
		Assert.assertEquals(3, MinimumSwaps2.minimumSwaps(new int[] {4, 3, 1, 2}));
		Assert.assertEquals(3, MinimumSwaps2.minimumSwaps(new int[] {1, 3, 5, 2, 4, 6, 7}));
	}

}
