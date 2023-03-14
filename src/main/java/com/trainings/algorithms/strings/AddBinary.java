package com.trainings.algorithms.strings;

/**
 * https://leetcode.com/problems/add-binary/description/
 * @author Thiago
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		// Convert the string to a decimal value
		Long aLong = Long.parseLong(a, 2);
		Long bLong = Long.parseLong(b, 2);
		
		// Sum the values
		Long cLong = aLong + bLong;
		
		// And then convert it back to binary and return.
		return Long.toBinaryString(cLong);
	}
}
