package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {}, MergeSort.sort(new int[] {}));
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, MergeSort.sort(new int[] { 3, 2, 1 }));
		Assert.assertArrayEquals(new int[] { -4, 1, 2, 3, 5, 6, 7, 8, 9, 10 }, MergeSort.sort(new int[] { 3, 8, 2, 1, -4, 7, 6, 5, 9, 10 }));
		Assert.assertArrayEquals(new int[] {1, 1, 2, 2, 3}, MergeSort.sort(new int[] {2, 1, 3, 1, 2}));
	}

}
