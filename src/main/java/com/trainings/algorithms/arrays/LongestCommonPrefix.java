package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

	public static String find(String[] values) {
		String lcp = "";

		Map<String, Boolean> prefixMap = new HashMap<>();
		for (String value : values) {
			for (int endIndex = value.length(); endIndex > lcp.length(); endIndex--) {
				String prefix = value.substring(0, endIndex);
				if (!prefixMap.containsKey(prefix)) {
					prefixMap.put(prefix, Boolean.TRUE);
				} else if (prefix.length() > lcp.length()) {
					lcp = prefix;
					break;
				}
			}
		}

		return lcp.isEmpty() ? "-1" : lcp;
	}

}
