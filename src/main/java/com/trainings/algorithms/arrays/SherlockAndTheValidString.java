package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SherlockAndTheValidString {
	public static String isValid(String s) {
		String valid = "NO";

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			Integer charQuantity = charMap.get(c);
			if (charQuantity != null) {
				charMap.put(c, ++charQuantity);
			} else {
				charMap.put(c, 1);
			}
		}

		HashSet<Integer> quantitySet = new HashSet<Integer>();
		quantitySet.addAll(charMap.values());

		int quantities = quantitySet.size();
		if (quantities == 1) {
			valid = "YES";
		} else if (quantities == 2) {
			Object[] quantitiesArray = quantitySet.toArray();
			if (Math.abs((Integer) quantitiesArray[0] - (Integer) quantitiesArray[1]) == 1) {
				valid = "YES";
			}
		}

		return valid;

	}
}
