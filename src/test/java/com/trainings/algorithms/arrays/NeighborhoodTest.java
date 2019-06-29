package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NeighborhoodTest {

	@Test
	void test() {
		Assert.assertTrue(Neighborhood.isValid(new char[][] {}, 0, 0));
		Assert.assertTrue(Neighborhood.isValid(new char[][] { { '0', 'A', 'E', 'B' }, { '0', 'C', '0', '0' },
				{ '0', '0', '0', '0' }, { '0', '0', 'D', 'D' } }, 4, 4));
		Assert.assertFalse(Neighborhood.isValid(new char[][] { { '0', 'A', 'E', 'B' }, { '0', 'B', '0', '0' },
			{ '0', '0', '0', '0' }, { '0', '0', 'D', 'D' } }, 4, 4));
	}

}
