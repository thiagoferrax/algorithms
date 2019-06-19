package com.trainings.algorithms.prefixsums;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PassingCarsTest {

	@Test
	void test() {
		PassingCars passingCars = new PassingCars();
		Assert.assertEquals(5, passingCars.solution(new int[] {0, 1, 0, 1, 1}));
		Assert.assertEquals(0, passingCars.solution(new int[] {0}));
		Assert.assertEquals(0, passingCars.solution(new int[] {1}));
		Assert.assertEquals(1, passingCars.solution(new int[] {0,1}));
		Assert.assertEquals(8, passingCars.solution(new int[] {0,1, 1, 1, 1, 1, 1, 1, 1}));
		Assert.assertEquals(0, passingCars.solution(new int[] {1,1, 1, 1, 1, 1, 1, 1, 1}));
	}

}
