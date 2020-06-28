package com.trainings.algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * MakingAnagrams - return an integer representing the minimum total characters
 * that must be deleted to make the strings anagrams.
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/
 * 
 * @author thiago
 *
 */
public class MakingAnagrams {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {

		char[] charsA = a.toCharArray();
		char[] charsB = b.toCharArray();

		Map<Character, Integer> mapA = getCharTimesMap(charsA);
		Map<Character, Integer> mapB = getCharTimesMap(charsB);

		int minRemovals = 0;
		for (char charA : mapA.keySet()) {
			if (mapB.containsKey(charA)) {
				minRemovals += Math.abs(mapA.get(charA) - mapB.get(charA));
			} else {
				minRemovals+=mapA.get(charA);
			}
		}

		for (char charB : mapB.keySet()) {
			if (!mapA.containsKey(charB)) {
				minRemovals+=mapB.get(charB);
			}
		}
		return minRemovals;

	}

	private static Map<Character, Integer> getCharTimesMap(char[] charsA) {
		Map<Character, Integer> mapA = new Hashtable<>();
		for (int i = 0; i < charsA.length; i++) {
			Integer times = mapA.get(charsA[i]);
			if (times == null) {
				times = 0;
				mapA.put(charsA[i], times);
			}

			mapA.put(charsA[i], ++times);
		}
		return mapA;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
