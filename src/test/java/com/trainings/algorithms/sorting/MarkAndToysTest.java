package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MarkAndToysTest {

	@Test
	void test() {
		Assert.assertEquals(4, MarkAndToys.maximumToys(new int[] {1, 12, 5, 111, 200, 1000, 10}, 50));
	}

}
