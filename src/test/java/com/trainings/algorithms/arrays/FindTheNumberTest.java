package com.trainings.algorithms.arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FindTheNumberTest {

	@Test
	void test() {
		Assert.assertEquals("NO", FindTheNumber.findNumber(Arrays.asList(2, 3, 1) , 5));
		Assert.assertEquals("YES", FindTheNumber.findNumber(Arrays.asList(2, 3, 5, 1) , 5));
	}

}
