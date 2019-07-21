package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CommonItemsTest {

	@Test
	void test() {
		CommonItems commonItems = new CommonItems();
		Assert.assertTrue(commonItems.solution(new char[] { 'a', 'b', 'c', 'x' }, new char[] { 'z', 'y', 'x' }));
		Assert.assertFalse(commonItems.solution(new char[] { 'a', 'b', 'c', 'x' }, new char[] { 'z', 'y', 'i' }));
	}

	@Test
	void testBruteForce() {
		CommonItems commonItems = new CommonItems();
		Assert.assertTrue(commonItems.bruteForceSolution(new char[] { 'a', 'b', 'c', 'x' }, new char[] { 'z', 'y', 'x' }));
		Assert.assertFalse(commonItems.bruteForceSolution(new char[] { 'a', 'b', 'c', 'x' }, new char[] { 'z', 'y', 'i' }));
	}
}
