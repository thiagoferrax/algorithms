package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {}, InsertionSort.sort(new int[] {}));
		Assert.assertArrayEquals(new int[] {1}, InsertionSort.sort(new int[] {1}));
		Assert.assertArrayEquals(new int[] {1, 2, 3}, InsertionSort.sort(new int[] {3, 2, 1}));
		Assert.assertArrayEquals(new int[] {1, 2, 3, 3, 5, 8}, InsertionSort.sort(new int[] {3, 2, 5, 3, 8, 1}));
	}

}
