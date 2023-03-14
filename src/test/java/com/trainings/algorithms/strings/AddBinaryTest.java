package com.trainings.algorithms.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddBinaryTest {

	@Test
	public void testOne() {
		assertEquals("100", new AddBinary().addBinary("11", "1"));
	}
	
	@Test
	public void testTwo() {
		assertEquals("10101", new AddBinary().addBinary("1010", "1011"));
	}
	
	@Test
	public void testThree() {
		assertEquals("1000", new AddBinary().addBinary("1", "111"));
	}
}
