package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NumberOfDiscIntersectionsTest {

	@Test
	void test() {
		NumberOfDiscIntersections discIntersections = new NumberOfDiscIntersections();
			Assert.assertEquals(11, discIntersections.solution(new int[] {1, 5, 2, 1, 4, 0}));
			Assert.assertEquals(2, discIntersections.solution(new int[] {1, 2147483647, 0}));
		}

}
