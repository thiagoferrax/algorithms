package com.trainings.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * @author Thiago
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {

		Set<Integer> set = new HashSet<>();
		set.add(0);
		for (int n : nums) {
		    set.add(n);
		}

		int[] numbersSet = new int[set.size()];

		int index = 0;
		for (Integer num : set) {
			numbersSet[index++] = num;
		}

		Arrays.sort(numbersSet);
		
		int firstMissingPositive = 1;
		int indexOfZero = Arrays.binarySearch(numbersSet, 0);

		if (indexOfZero + 1 < numbersSet.length) {
			int firstPositive = numbersSet[indexOfZero + 1];

			if (firstPositive == 1) {
				int current = 1;

				for (int i = indexOfZero + 1; i < numbersSet.length; i++) {
					int previous = numbersSet[i - 1];
					current = numbersSet[i];

					if (current - previous > 1) {
						firstMissingPositive = previous + 1;
						break;
					}
				}

				if (firstMissingPositive == 1) {
					firstMissingPositive = current + 1;
				}
			}
		} 

		return firstMissingPositive;
	}
}
