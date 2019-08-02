package com.trainings.algorithms.sorting;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void test() {
		//Assert.assertArrayEquals(new int[] {}, MergeSort.sort(new int[] {}));
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, MergeSort.sort(new int[] { 3, 2, 1 }));
	}

}
