package com.trainings.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class SpecialStringAgain {

	static long substrCount(int n, String s) {
		return (long) substrCountObj(n, s, new HashMap<String, Boolean>(), 0)[0];
	}

	static Object[] substrCountObj(int n, String s, Map<String, Boolean> memory, int index) {
		String key = s + "_" + index;
		if (memory.containsKey(key)) {
			return new Object[] { 0L, memory.get(key) };
		}

		long count = 0;
		Boolean special = false;

		if (n == 0) {
			return new Object[] { 0L, Boolean.TRUE };
		} else if (n == 1) {
			memory.put(key, Boolean.TRUE);
			return new Object[] { 1L, Boolean.TRUE };
		}
		if (n % 2 == 0) {
			if (n == 2) {

				Object[] one = substrCountObj(1, String.valueOf(s.charAt(0)), memory, index);
				Object[] two = substrCountObj(1, String.valueOf(s.charAt(1)), memory, index + 1);

				long sum = (long) one[0] + (long) two[0];

				special = s.charAt(0) == s.charAt(1);
				count = special ? 1 + sum : sum;

				memory.put(key, special);

				return new Object[] { count, special };
			} else {
				if (s.charAt(0) == s.charAt(1) && s.charAt(n - 1) == s.charAt(n - 2)) {
					long wholeStringSpecial = 0L;
					Object[] response = substrCountObj(n - 2, s.substring(1, n - 1), memory, index + 1);
					boolean substringSpecial = ((Boolean) response[1]).equals(Boolean.TRUE);
					if (substringSpecial) {
						wholeStringSpecial++;
					}

					memory.put(key, substringSpecial);
					return new Object[] { 2 + wholeStringSpecial + (long) response[0], substringSpecial };
				} else {
					Object[] responseA = substrCountObj(n - 1, s.substring(1, n), memory, index + 1);
					Object[] responseB = substrCountObj(n - 1, s.substring(0, n - 1), memory, index);

					memory.put(key, Boolean.FALSE);
					return new Object[] { ((Long) responseA[0]) + (Long) responseB[0], Boolean.FALSE };
				}
			}
		} else {
			if (n == 3) {
				Object[] one = substrCountObj(1, String.valueOf(s.charAt(0)), memory, index);
				Object[] two = substrCountObj(1, String.valueOf(s.charAt(1)), memory, index + 1);
				Object[] three = substrCountObj(1, String.valueOf(s.charAt(2)), memory, index + 2);

				long sum = (long) one[0] + (long) two[0] + (long) three[0];

				special = s.charAt(0) == s.charAt(n - 1);
				count += special ? 1 + sum : sum;

				memory.put(key, special);

				return new Object[] { count, special };
			} else {
				if (s.charAt(0) == s.charAt(n - 1)) {
					long wholeStringSpecial = 0L;

					Object[] response = substrCountObj(n - 2, s.substring(1, n - 1), memory, index + 1);
					boolean substringSpecial = ((Boolean) response[1]).equals(Boolean.TRUE);
					if (substringSpecial) {
						wholeStringSpecial++;
					}

					memory.put(s, substringSpecial);
					return new Object[] { 2 + wholeStringSpecial + (long) response[0], substringSpecial };
				} else {
					Object[] responseA = substrCountObj(n - 1, s.substring(1, n), memory, index + 1);
					Object[] responseB = substrCountObj(n - 1, s.substring(0, n - 1), memory, index);

					memory.put(key, Boolean.FALSE);
					return new Object[] { ((Long) responseA[0]) + (Long) responseB[0], Boolean.FALSE };
				}

			}
		}

	}

}
