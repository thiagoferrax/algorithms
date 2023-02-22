package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

public class InterleavingStringTest {

	@Test
	public void testOne() {
		Assert.assertEquals(true, new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	@Test
	public void testTwo() {
		Assert.assertEquals(true, new InterleavingString().isInterleave("", "", ""));
	}
	
	@Test
	public void testThree() {
		Assert.assertEquals(true, new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
}
