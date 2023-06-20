package com.trainings.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class TheMaximumSubArray {
    public static List<Integer> maxSubarray(List<Integer> numbers) {
        List<Integer> maxSums = new ArrayList<>();

        int maxSubArray = 0, maxSubSequence = 0, currentSum = 0, count = 0, maxSubSequenceAllNegative = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            //Subsequence max sum calculation
            if(number > 0) {
                maxSubSequence += number;
            } else {
                maxSubSequenceAllNegative = Math.max(maxSubSequenceAllNegative, number);
                count++;
            }

            //Subarray max sum calculation
            if(i == 0) {
                currentSum = number;
                maxSubArray = number;
            } else {
                currentSum = Math.max(number, currentSum + number);
                maxSubArray = Math.max(maxSubArray, currentSum);
            }
        }

        maxSums.add(maxSubArray);
        maxSums.add(count == numbers.size() ? maxSubSequenceAllNegative : maxSubSequence);

        return maxSums;
    }

}
