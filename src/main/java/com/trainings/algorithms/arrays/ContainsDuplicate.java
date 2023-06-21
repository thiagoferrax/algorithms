package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] ints) {
        Map<Integer, Integer> numberQuantityMap = new HashMap<>();
        for(int number : ints) {
            int quanitty = numberQuantityMap.getOrDefault(number, 0);
            quanitty++;
            if(quanitty > 1) {
                return true;
            }
            numberQuantityMap.put(number, quanitty);
        }
        return false;
    }
}
