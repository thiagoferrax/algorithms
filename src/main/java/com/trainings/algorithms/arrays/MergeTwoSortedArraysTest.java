package com.trainings.algorithms.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MergeTwoSortedArraysTest {

	@Test
	void test() {
		assertEquals(new int[] { 1, 2, 3, 4, 4, 5, 6, 8 },
				MergeTwoSortedArrays.mergeArrays(new int[] { 1, 3, 4, 5 }, new int[] { 2, 4, 6, 8 }, 4, 4));
	}

}
