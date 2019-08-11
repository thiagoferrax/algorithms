package com.trainings.algorithms.technicaltest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaxEventsTest {

	@Test
	void test() {
		Assert.assertEquals(3, ResultMaxEvents.maxEvents(Arrays.asList(1, 3, 5), Arrays.asList(2, 2, 2)));
		Assert.assertEquals(2, ResultMaxEvents.maxEvents(Arrays.asList(1, 1, 1, 1, 4), Arrays.asList(10, 3, 6, 4, 2)));
	}

}
