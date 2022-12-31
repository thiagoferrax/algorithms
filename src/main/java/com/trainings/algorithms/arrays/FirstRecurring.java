package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find first recurring element in an array of integers.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12314712#content
 */
public class FirstRecurring {

    public Integer getFirstRecurring(int[] array) {
        if (array != null && array.length != 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int key : array) {
                if (map.containsKey(key)) {
                    return key;
                }
                map.put(key, 1);
            }
        }

        return null;
    }

}
