package com.trainings.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class SpecialStringAgain {

	static long substrCount(int n, String s) {
		return buildSubstringMemory(n, s, new HashMap<String, Boolean>(), 0, 0);
	}

	static long buildSubstringMemory(int n, String s, Map<String, Boolean> memory, int index, long count) {
		String key = buildKey(s, index);

		if (memory.containsKey(key) || n == 0) {
			return count;
		}

		if (n == 1) {
			memory.put(key, Boolean.TRUE);
			++count;
		} else {
			String left = s.substring(0, n - 1);
			String right = s.substring(1, n);
			if (n <= 3) {
				count = buildSubstringMemory(n - 1, left, memory, index, count);
				count = buildSubstringMemory(n - 1, right, memory, index + 1, count);

				boolean special = s.charAt(0) == s.charAt(n - 1);
				memory.put(key, special);

				if (special) {
					++count;
				}
			} else {
				count = buildSubstringMemory(n - 1, left, memory, index, count);
				count = buildSubstringMemory(n - 1, right, memory, index + 1, count);

				String substringKey = buildKey(s.substring(1, n - 1), index + 1);

				boolean special = memory.get(substringKey) && s.charAt(0) == s.charAt(1) && s.charAt(n - 2) == s.charAt(n - 1);
				
				memory.put(key, special);

				if (special) {
					++count;
				}
			}
		}

		return count;
	}

	private static String buildKey(String s, int index) {
		return s + "_" + index;
	}

}
