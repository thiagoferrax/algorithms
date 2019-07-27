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
		for (char charAt : firstWord.toCharArray()) {
			incrementCounter(firstWordMap, charAt);
		}

		Map<Character, Integer> secondWordMap = new HashMap<Character, Integer>();
		for (char charAt : secondWord.toCharArray()) {
			if (!firstWordMap.containsKey(charAt)) {
				return false;
			} else {
				incrementCounter(secondWordMap, charAt);
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

	private static void incrementCounter(Map<Character, Integer> wordMap, char charAt) {
		if (!wordMap.containsKey(charAt)) {
			wordMap.put(charAt, 1);
		} else {
			Integer count = wordMap.get(charAt);
			wordMap.put(charAt, count + 1);
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
