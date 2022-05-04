package com.trainings.algorithms.strings;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CommonChild {
	public static int commonChild(String s1, String s2) {
		Set<String> common = childrenOf(s1);
		common.retainAll(childrenOf(s2));
		return common.stream().max(Comparator.comparing(s -> s.length())).orElse("").length();
	}

	public static Set<String> childrenOf(String s1) {
		Set<String> children = new HashSet<String>();
		int length = s1.length();

		for (int i = 1; i < Math.pow(2, length); i++) {
			char[] mask = Integer.toBinaryString(i).toCharArray();
			String child = getChild(s1, mask);
			children.add(child);
		}

		return children;
	}

	public static String getChild(String s1, char[] mask) {
		StringBuilder builder = new StringBuilder();
		for (int m = mask.length - 1; m >= 0; m--) {
			if (mask[m] == '1') {
				builder.append(s1.charAt(m + (s1.length() - mask.length)));
			}
		}

		return builder.reverse().toString();
	}
}
