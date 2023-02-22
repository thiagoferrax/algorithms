package com.trainings.algorithms.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * @author Thiago
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {

		int[] numbersSet = Arrays.copyOf(nums, nums.length + 1);
		numbersSet[nums.length] = 0;
		Arrays.sort(numbersSet);

		int firstMissingPositive = 1;
		int indexOfZero = Arrays.binarySearch(numbersSet, 0);

		int firstPositive = 0;
		while (indexOfZero + 1 < numbersSet.length && numbersSet[indexOfZero + 1] == 0) {
			indexOfZero++;
		}

		if (indexOfZero + 1 < numbersSet.length) {
			firstPositive = numbersSet[indexOfZero + 1];

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
