package com.trainings.algorithms.countingelements;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FrogRiverOneTest {

	@Test
	void test() {
		FrogRiverOne frogRiverOne = new FrogRiverOne();

		Assert.assertEquals(0, frogRiverOne.solution(1, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		Assert.assertEquals(4, frogRiverOne.solution(3, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		Assert.assertEquals(6, frogRiverOne.solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		Assert.assertEquals(-1, frogRiverOne.solution(2, new int[] { 2, 2, 2, 2, 2 }));
		Assert.assertEquals(-1, frogRiverOne.solution(3, new int[] { 1, 2 }));
		Assert.assertEquals(1, frogRiverOne.solution(2, new int[] { 2, 1 }));
		Assert.assertEquals(-1, frogRiverOne.solution(2, new int[] {}));
		Assert.assertEquals(6, frogRiverOne.solution(4, new int[] { 1, 2, 4, 4, 6, 2, 3, 6, 7, 2, 4, 3 }));
		Assert.assertEquals(4, frogRiverOne.solution(3, new int[] { 1, 3, 1, 3, 2, 1, 3 }));
	}
}