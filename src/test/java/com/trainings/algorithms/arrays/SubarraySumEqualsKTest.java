package com.trainings.algorithms.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubarraySumEqualsKTest {

	@Test
	public void testOne() {
		assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[] {1,1,1}, 2));
	}
	
	@Test
	public void testTwo() {
		assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[] {1,2,3}, 3));
	}
	
	@Test
	public void testThree() {
		assertEquals(3, new SubarraySumEqualsK().subarraySum(new int[] {1,-1,0}, 0));
	}

}
