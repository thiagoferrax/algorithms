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
		assertEquals("10101", new AddBinary().addBinary(
				"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
}
