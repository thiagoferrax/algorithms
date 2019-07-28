package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void test() {
		Assert.assertEquals(0, BubbleSort.bubbleSort(new int[] {1, 2, 3}));
		Assert.assertEquals(1, BubbleSort.bubbleSort(new int[] {2, 1, 3}));
	}

}
