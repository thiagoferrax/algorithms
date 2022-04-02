package com.trainings.algorithms.arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SherlockAndTheValidString {
	public static String isValid(String s) {
		String valid = "YES";

		char[] word = s.toCharArray();

		if (word.length <= 1) {
			return "YES";
		}

		Map<Character, Integer> charQuantityMap = new HashMap<Character, Integer>();
		for (char c : word) {
			Integer quantity = charQuantityMap.get(c);
			charQuantityMap.put(c, quantity != null ? ++quantity : 1);
		}

		HashSet<Integer> quantitySet = new HashSet<Integer>();
		Collection<Integer> values = charQuantityMap.values();
		quantitySet.addAll(values);

		if (quantitySet.size() == 1) {
			// All quantities are the same.
			return "YES";
		} else if (quantitySet.size() > 2) {
			// More than three quantities so it's not possible to remove one and have all
			// characters with same quantities.
			return "NO";
		} else {
			// Quantities are different and there are only two different quantities

			Integer equals = 0;
			Integer different = 0;

			Integer aQuantity = values.iterator().next();
			Integer diffQuantity = null;

			for (Integer quantity : values) {
				if (aQuantity == quantity) {
					equals++;
				} else {
					diffQuantity = quantity;
					different++;
				}
			}

			if (Math.abs(aQuantity - diffQuantity) > 1) {
				// Who has the majority?
				if (equals == values.size() - 1 && diffQuantity == 1) {
					// Almost all characters has the aQuantity and just one character has a
					// diffQuantity
					valid = "YES";
				} else if (different == values.size() - 1 && aQuantity == 1) {
					// Almost all characters has the diffQuantity and just one character has a
					// aQuantity
					valid = "YES";
				} else {
					valid = "NO";
				}

			} else {
				if (equals == values.size() - 1 && (diffQuantity == 1 || diffQuantity > aQuantity)) {
					valid = "YES";
				} else if (different == values.size() - 1 && (aQuantity == 1 || aQuantity > diffQuantity)) {
					valid = "YES";
				} else {
					valid = "NO";
				}
			}
		}

		return valid;

	}

	private static String readAllBytesJava7(String filePath) {
		String content = "";

		try {
			Path path = Paths.get(filePath);
			
			byte[] readAllBytes = Files.readAllBytes(path);
			content = new String(readAllBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	public static void main(String[] args) {
		String filePath = "C:\\Users\\thiag\\Documents\\input13.txt";

		String input13 = readAllBytesJava7(filePath);
		
		String valid = isValid(input13);
		
		System.out.println(valid);
	}
}
