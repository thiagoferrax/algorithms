package com.trainings.algorithms.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/add-binary/description/
 * @author Thiago
 *
 */
public class AddBinary {
	
	public String addBinary(String a, String b) {
		
		int maxLength = Math.max(a.length(), b.length());
		
		char[] aArray = Arrays.copyOf(new StringBuilder(a).reverse().toString().toCharArray(), maxLength);
		char[] bArray = Arrays.copyOf(new StringBuilder(b).reverse().toString().toCharArray(), maxLength);
		
		//System.out.println(Arrays.toString(aArray));
		//System.out.println(Arrays.toString(bArray));
		
		char up = '0';
		
		char[] sum = new char[maxLength];
		
		for (int i = 0; i < aArray.length; i++) {
			char aChar = getChar(aArray, i);
			char bChar = getChar(bArray, i);
		
			if(aChar != bChar) {
				sum[i] = '1';
				if(up == '1') {
					sum[i] = '0';
					up = '1';
				}
			} else if (aChar == '1'){
				if(up == '1') {
					sum[i] = '1';
				} else {
					sum[i] = '0';
				}
				up = '1';
			} else {
				sum[i] = up;
				up = '0';
			}
		}
		
		if(up == '1') {
			sum = Arrays.copyOf(sum, maxLength + 1);
			sum[maxLength] = up;
		}
		
		return new StringBuilder(new String(sum)).reverse().toString();
	}

	private char getChar(char[] aArray, int i) {
		return aArray[i] != '1' && aArray[i] != '0' ? '0' : aArray[i];
	}
	
	public String addBinary1stSolution(String a, String b) {
		// Convert the string to a decimal value
		Long aLong = Long.parseLong(a, 2);
		Long bLong = Long.parseLong(b, 2);
		
		// Sum the values
		Long cLong = aLong + bLong;
		
		// And then convert it back to binary and return.
		return Long.toBinaryString(cLong);
	}
}
