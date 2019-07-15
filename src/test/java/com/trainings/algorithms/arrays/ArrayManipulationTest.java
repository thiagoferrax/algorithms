package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ArrayManipulationTest {

	@Test
	void test() {
		Assert.assertEquals(200L,
				ArrayManipulation.arrayManipulation(5, new int[][] { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } }));
	}

}
