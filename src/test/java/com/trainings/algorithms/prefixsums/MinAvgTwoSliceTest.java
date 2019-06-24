package com.trainings.algorithms.prefixsums;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class MinAvgTwoSliceTest {

	@Test
	void test() {
		MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
		
		Assert.assertEquals(1, minAvgTwoSlice.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));			
		Assert.assertEquals(0, minAvgTwoSlice.solution(new int[] {2, 3, 7, 1}));
	}

}
