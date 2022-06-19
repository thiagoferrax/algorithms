package com.trainings.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Abbreviation {
	public static String abbreviation(String a, String b) {
		a.toCharArray();

		List<Character> aList = asList(a);
		List<Character> bList = asList(b);
		List<Character> aListTmp = asList(a);
		List<Character> bListTmp = asList(b);

		// The car
		bListTmp.removeAll(aList);

		System.out.println(bListTmp);

		aListTmp.removeAll(bList);

		List<Character> toRemove = new ArrayList<>();

		for (Character ca : aListTmp) {
			if (!bListTmp.contains(ca) && !bListTmp.contains(Character.toUpperCase(ca))) {
				if (Character.isLowerCase(ca)) {
					toRemove.add(ca);
				}
			}
		}

		aList.removeAll(toRemove);

		return aList.stream().map(e -> e.toString()).reduce((acc, e) -> acc + e).get().equalsIgnoreCase(b) ? "YES"
				: "NO";
	}

	private static List<Character> asList(String a) {
		return a.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
	}
}
