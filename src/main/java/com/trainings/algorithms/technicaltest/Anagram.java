package com.trainings.algorithms.technicaltest;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			String firstWord = scan.next();
			String secondWord = scan.next();

			System.out.println(isAnagram(firstWord, secondWord));
			
		}

		scan.close();
	}

	public static boolean isAnagram(String firstWord, String secondWord) {
		if(firstWord.length() != secondWord.length()) {
			return false;
		}
		
		char[] firstWordArray = firstWord.toCharArray();
		char[] secondWordArray = secondWord.toCharArray();
		
		Arrays.sort(firstWordArray);
		Arrays.sort(secondWordArray);
		
		return new String(firstWordArray).equalsIgnoreCase(new String(secondWordArray));
	}
}
