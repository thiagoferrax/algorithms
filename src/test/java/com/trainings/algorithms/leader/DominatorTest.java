package com.trainings.algorithms.leader;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DominatorTest {

	@Test
	void test() {
		Dominator dominator = new Dominator();
		Assert.assertEquals(0, dominator.solution(new int[] {3, 4, 3, 2, 3, -1, 3, 3}));
		Assert.assertEquals(0, dominator.solution(new int[] {2147483647}));
		Assert.assertEquals(2, dominator.solution(new int[] {0, 0, 1, 1, 1}));
		Assert.assertEquals(-1, dominator.solution(new int[] {0, 0, 1, 1}));
	}

}
