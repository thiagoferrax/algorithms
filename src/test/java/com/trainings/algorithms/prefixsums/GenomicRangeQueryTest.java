package com.trainings.algorithms.prefixsums;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GenomicRangeQueryTest {

	@Test
	void test() {
		GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
		Assert.assertArrayEquals(new int[] {2, 4, 1}, genomicRangeQuery.solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}));
	}

}
