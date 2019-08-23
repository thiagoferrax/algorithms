package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ArrayManipulationTest {

	@Test
	void test() {
		Assert.assertEquals(200L,
				ArrayManipulation.arrayManipulation(5, new int[][] { { 1, 2, 100 }, { 2, 5, 100 }, { 3, 4, 100 } }));
		Assert.assertEquals(70L,
				ArrayManipulation.arrayManipulation(4, new int[][] { { 1, 2, 50 }, { 3, 4, 10 }, { 1, 4, 20 } }));
		Assert.assertEquals(250L,
				ArrayManipulation.arrayManipulation(5, new int[][] { { 1, 2, 240 }, { 3, 4, -20 }, { 3, 5, 250 } }));
		
//		Assert.assertEquals(31L,
//				ArrayManipulation.arrayManipulation(10, new int[][] { { 2, 6, 8 }, { 3, 5, 7 }, { 1, 8, 1 }, { 5, 9, 15 } }));
	}

}
