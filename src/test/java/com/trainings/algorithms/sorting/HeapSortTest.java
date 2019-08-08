package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {}, HeapSort.sort(new int[] {}));
		Assert.assertArrayEquals(new int[] {1}, HeapSort.sort(new int[] {1}));
		Assert.assertArrayEquals(new int[] {3, 4, 5}, HeapSort.sort(new int[] {4, 5, 3}));
		Assert.assertArrayEquals(new int[] {2, 3, 4, 5, 5, 7, 9}, HeapSort.sort(new int[] {4, 7, 5, 5, 2, 3, 9}));
		Assert.assertArrayEquals(new int[] {-23, -8, -2, 2, 3, 4, 5, 5, 7, 9}, HeapSort.sort(new int[] {-2, 4, 7, -8, 5, 5, 2, -23, 3, 9}));
	}

}
