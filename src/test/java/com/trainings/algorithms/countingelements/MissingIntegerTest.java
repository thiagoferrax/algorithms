package com.trainings.algorithms.countingelements;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MissingIntegerTest {

	@Test
	void test() {
		MissingInteger missingInteger = new MissingInteger();
		
		Assert.assertEquals(4, missingInteger.solution(new int[] {1, 2, 3}));
		Assert.assertEquals(1, missingInteger.solution(new int[] {-1, -3}));
		Assert.assertEquals(5, missingInteger.solution(new int[] {1, 3, 6, 4, 1, 2}));
		Assert.assertEquals(1, missingInteger.solution(new int[] {2}));
		Assert.assertEquals(1, missingInteger.solution(new int[] {4, 5, 6, 2}));
	}

}
