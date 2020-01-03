package com.trainings.algorithms.dictionariesandhashmaps;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CountTripletsTest {

	@Test
	void test() {	
		Assert.assertEquals(2, CountTriplets.countTriplets(Arrays.asList(1L, 4L, 16L, 64L), 4));
		Assert.assertEquals(2, CountTriplets.countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2));
		Assert.assertEquals(6, CountTriplets.countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3));
		Assert.assertEquals(4, CountTriplets.countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5));
		Assert.assertEquals(6, CountTriplets.countTriplets(Arrays.asList(1L, 1L, 5L, 5L, 25L, 125L), 5));
		Assert.assertEquals(4, CountTriplets.countTriplets(Arrays.asList(1L, 1L, 1L, 1L), 1));
		Assert.assertEquals(10, CountTriplets.countTriplets(Arrays.asList(1L, 1L, 1L, 1L, 1L), 1));
	}

}
