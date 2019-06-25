package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class DistinctTest {

	@Test
	void test() {
		Distinct distinct = new Distinct();
		
		Assert.assertEquals(0, distinct.solution(new int[] {}));
		Assert.assertEquals(3, distinct.solution(new int[] {2, 1, 1, 2, 3, 1}));
		Assert.assertEquals(1, distinct.solution(new int[] {2, 2, 2, 2, 2, 2, 2}));
	}

}
