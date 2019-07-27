package com.trainings.algorithms.technicaltest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		if (firstWord.length() != secondWord.length()) {
			return false;
		}

		Map<Character, Integer> firstWordMap = new HashMap<Character, Integer>();
		for (int n = 0; n < firstWord.length(); n++) {
			char charAt = firstWord.charAt(n);
			incrementCount(firstWordMap, charAt);
		}

		Map<Character, Integer> secondWordMap = new HashMap<Character, Integer>();
		for (int m = 0; m < firstWord.length(); m++) {
			char charAt = firstWord.charAt(m);
			if (!firstWordMap.containsKey(charAt)) {
				return false;
			} else {
				incrementCount(secondWordMap, charAt);
			}
		}
		
		if(firstWordMap.size() != secondWordMap.size()) {
			return false;
		}
		
		for(char charAt : firstWordMap.keySet()) {
			if (!secondWordMap.containsKey(charAt) || firstWordMap.get(charAt) != secondWordMap.get(charAt)) {
				return false;
			}
		}
		
		return true;
	}

	private static void incrementCount(Map<Character, Integer> firstWordMap, char charAt) {
		if (!firstWordMap.containsKey(charAt)) {
			firstWordMap.put(charAt, 1);
		} else {
			Integer count = firstWordMap.get(charAt);
			firstWordMap.put(charAt, count + 1);
		}
	}

	public static boolean isAnagramFirstSolution(String firstWord, String secondWord) {
		if (firstWord.length() != secondWord.length()) {
			return false;
		}

		char[] firstWordArray = firstWord.toCharArray();
		char[] secondWordArray = secondWord.toCharArray();

		Arrays.sort(firstWordArray);
		Arrays.sort(secondWordArray);

		return new String(firstWordArray).equalsIgnoreCase(new String(secondWordArray));
	}
}
