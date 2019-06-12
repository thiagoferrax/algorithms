package com.trainings.algorithms.countingelements;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PermCheckTest {

	@Test
	void test() {
		PermCheck permCheck = new PermCheck();		
		Assert.assertEquals(0, permCheck.solution(new int[] {}));		
		Assert.assertEquals(0, permCheck.solution(new int[] {7}));
		Assert.assertEquals(1, permCheck.solution(new int[] {1}));
		Assert.assertEquals(0, permCheck.solution(new int[] {1, 1}));
	}

}
