package com.trainings.algorithms.warmup;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CountingValleysTest {

	@Test
	void test() {
		Assert.assertEquals(1, CountingValleys.countingValleys(8, "UDDDUDUU"));
		Assert.assertEquals(4, CountingValleys.countingValleys(8, "DUDUDUDU"));
		Assert.assertEquals(1, CountingValleys.countingValleys(8, "DDDDUUUU"));
	}

}
