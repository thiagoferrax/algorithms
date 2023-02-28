package com.trainings.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * @author Thiago
 *
 */
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		List<List<Integer>> subarrays = getSubarrays(nums);

		int count = 0;
		for (List<Integer> subarray : subarrays) {
			Integer sum = subarray.stream().reduce(0, (a, b) -> a + b);
			if (sum == k) {
				count++;
			}
		}

		return count;
	}

	private List<List<Integer>> getSubarrays(int[] nums) {
		double maxSubarrays = Math.pow(2, nums.length);

		List<List<Integer>> subarrays = new ArrayList<>();
		for (int i = 1; i < maxSubarrays; i++) {
			String binaryString = Integer.toBinaryString(i);
			char[] binaryArray = new StringBuilder(binaryString).reverse().toString().toCharArray();

			List<Integer> subarray = new ArrayList<>();
			boolean contiguous = true, up = false, down = false;
			for (int j = 0; j < binaryArray.length; j++) {
				if (binaryArray[j] == '1') {
					int number = nums[j];
					subarray.add(number);

					if (up && down) {
						// There are zeros between ones.
						contiguous = false;
						break;
					}

					up = true;
				} else if (up) {
					down = true;
				}
			}

			if (contiguous) {
				subarrays.add(subarray);
			} 
		}
		return subarrays;
	}
}
