package com.trainings.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> memoization = new HashMap<>();
        return climb(n, memoization);
    }

    private int climb(int n, Map<Integer, Integer> memoization) {
        if(n<=2) {
            return n;
        } else if(memoization.containsKey(n)) {
            return memoization.get(n);
        }
        int climbN = climb(n-1, memoization) + climb(n-2, memoization);
        memoization.put(n, climbN);
        return climbN;
    }
}
