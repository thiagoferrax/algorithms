package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class GetTheMaximumScore {

    public int maxSum(int[] nums1, int[] nums2) {

        // Consider creating hashmaps to facilitate checking if an element is in a array
        Map<Integer, Integer> elementIndexMap1 = buildMap(nums1);
        Map<Integer, Integer> elementIndexMap2 = buildMap(nums2);

        // Variable to keep the sum to keep the maximum
        // Iterate through these paths and find the one that is maximum
        // return the sum of its elements

        return Math.max(maxSum(ARRAY.One, 0, 0, nums1, nums2, elementIndexMap1, elementIndexMap2, 0),
                maxSum(ARRAY.Two, 0, 0, nums1, nums2, elementIndexMap1, elementIndexMap2, 0));
    }

    private int maxSum(ARRAY array, int one, int two, int[] nums1, int[] nums2, Map<Integer, Integer> map1, Map<Integer, Integer> map2, int path) {

        int max = 0;

        if (ARRAY.One.equals(array)) {
            if (map2.containsKey(nums1[one]) && (map2.get(nums1[one]) + 1) < nums2.length)
                max = maxSum(ARRAY.Two, one, map2.get(nums1[one]) + 1, nums1, nums2, map1, map2, path + nums1[one]);

            if (one + 1 < nums1.length)
                max = Math.max(max, maxSum(ARRAY.One, one + 1, two, nums1, nums2, map1, map2, path + nums1[one]));

            if (one == nums1.length - 1)
                return Math.max(max, path + nums1[one]);

        } else {

            if (map1.containsKey(nums2[two]) && (map1.get(nums2[two]) + 1) < nums1.length)
                max = maxSum(ARRAY.One, map1.get(nums2[two]) + 1, two, nums1, nums2, map1, map2, path + nums2[two]);

            if (two + 1 < nums2.length)
                max = Math.max(max, maxSum(ARRAY.Two, one, two + 1, nums1, nums2, map1, map2, path + nums2[two]));

            if (two == nums2.length - 1) {
                return Math.max(max, path + nums2[two]);
            }
        }

        return max;
    }

    public Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map;
    }

    enum ARRAY {One, Two}

}
