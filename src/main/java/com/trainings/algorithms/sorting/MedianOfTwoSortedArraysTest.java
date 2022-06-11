package com.trainings.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MedianOfTwoSortedArraysTest {

	@Test
	void testHappyDay() {
		assertEquals(2.0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
	}
	
	@Test
	void testSecondHappyDay() {
		assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1,2}, new int[] {3, 4}));
	}

}
