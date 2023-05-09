package com.trainings.algorithms.arrays;

import java.util.*;

public class GetTheMaximumScore {

    public int maxSum(int[] nums1, int[] nums2) {

        // Consider creating hashmaps to facilitate checking if an element is in a array
        Map<Integer, Integer> elementIndexMap1 = buildMap(nums1);
        Map<Integer, Integer> elementIndexMap2 = buildMap(nums2);

        List<String> allPaths = new ArrayList<>();

        findAllPossiblePaths(ARRAY.One, 0, 0 , nums1, nums2, elementIndexMap1, elementIndexMap2, "", allPaths);

        findAllPossiblePaths(ARRAY.Two, 0, 0 , nums1, nums2, elementIndexMap1, elementIndexMap2, "", allPaths);

        int maximumSum =  1;
        for (String path : allPaths) {
            int currentSum = Arrays.stream(path.split(",")).map(Integer::parseInt).reduce((integer, integer2) -> integer + integer2).get();
            maximumSum = Math.max(maximumSum, currentSum);
        }

        // Variable to keep the sum to keep the maximum
        // Iterate throught these paths and find the one that is maximum
        // return the sum of its elements

        return maximumSum;
    }

    enum ARRAY {One, Two}

    private void findAllPossiblePaths(ARRAY array, int one, int two, int[] nums1, int[] nums2, Map<Integer, Integer> map1, Map<Integer, Integer> map2, String path, List<String> allPaths) {

        if(ARRAY.One.equals(array)) {
            if(one >= nums1.length) {
                return;
            }

            if(one == nums1.length - 1) {
                allPaths.add(path.isEmpty() ? String.valueOf(nums1[one]) : path + "," + nums1[one]);
                return;
            }

            if(map2.containsKey(nums1[one])) {
                findAllPossiblePaths(ARRAY.Two, one, map2.get(nums1[one]) + 1, nums1, nums2, map1, map2, path.isEmpty() ? String.valueOf(nums1[one]) : path + "," + nums1[one], allPaths);
            }
            findAllPossiblePaths(ARRAY.One, one + 1, two, nums1, nums2, map1, map2, path.isEmpty() ? String.valueOf(nums1[one]) : path + "," + nums1[one], allPaths);
        } else {
            if(two >= nums2.length) {
                return;
            }

            if(two == nums2.length - 1) {
                allPaths.add(path.isEmpty() ? String.valueOf(nums2[two]) : path + "," + nums2[two]);
                return;
            }

            if(map1.containsKey(nums2[two])) {
                findAllPossiblePaths(ARRAY.One, map1.get(nums2[two]) + 1, two, nums1, nums2, map1, map2, path.isEmpty() ? String.valueOf(nums2[two]) : path + "," + nums2[two], allPaths);
            }
            findAllPossiblePaths(ARRAY.Two, one, two + 1, nums1, nums2, map1, map2, path.isEmpty() ? String.valueOf(nums2[two]) : path + "," + nums2[two], allPaths);
        }
    }

    public Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map;
    }

}
