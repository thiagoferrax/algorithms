package com.trainings.algorithms.countingelements;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaxCountersTest {

	@Test
	void test() {
		MaxCounters maxCounters = new MaxCounters();
		Assert.assertArrayEquals(new int[] { 3, 2, 2, 4, 2 },
				maxCounters.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }));
		Assert.assertArrayEquals(new int[] { 4 }, maxCounters.solution(1, new int[] { 1, 2, 1, 1, 1, 2, 2 }));
		Assert.assertArrayEquals(new int[] { 0, 0 }, maxCounters.solution(2, new int[] { 3, 3, 3, 3, 3, 3, 3 }));
		Assert.assertArrayEquals(new int[] { 0, 7 }, maxCounters.solution(2, new int[] { 2, 2, 2, 2, 2, 2, 2 }));
		Assert.assertArrayEquals(new int[] { 7, 0 }, maxCounters.solution(2, new int[] { 1, 1, 1, 1, 1, 1, 1 }));
	}

	@Test
	void testBestSolution() {
		MaxCounters maxCounters = new MaxCounters();

		Assert.assertArrayEquals(new int[] { 3, 2, 2, 4, 2 },
				maxCounters.bestSolution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }));
		Assert.assertArrayEquals(new int[] { 4 }, maxCounters.bestSolution(1, new int[] { 1, 2, 1, 1, 1, 2, 2 }));
		Assert.assertArrayEquals(new int[] { 0, 0 }, maxCounters.bestSolution(2, new int[] { 3, 3, 3, 3, 3, 3, 3 }));
		Assert.assertArrayEquals(new int[] { 0, 7 }, maxCounters.bestSolution(2, new int[] { 2, 2, 2, 2, 2, 2, 2 }));
		Assert.assertArrayEquals(new int[] { 7, 0 }, maxCounters.bestSolution(2, new int[] { 1, 1, 1, 1, 1, 1, 1 }));
	}

}
