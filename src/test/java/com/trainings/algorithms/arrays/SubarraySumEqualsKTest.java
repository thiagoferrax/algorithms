package com.trainings.algorithms.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SubarraySumEqualsKTest {

	@Test
	public void testOne() {
		assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[] {1,1,1}, 2));
	}
	
	@Test
	public void testTwo() {
		assertEquals(2, new SubarraySumEqualsK().subarraySum(new int[] {1,2,3}, 3));
	}

}
