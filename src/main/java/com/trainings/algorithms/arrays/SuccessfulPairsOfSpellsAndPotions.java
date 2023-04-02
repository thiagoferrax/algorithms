package com.trainings.algorithms.arrays;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">successful-pairs-of-spells-and-potions</a>
 */
public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];

        int sIndex = 0, pIndex = 0, count = 0;
        for (int i = 0; i < spells.length * potions.length; i++) {
            long multiplication = (long) spells[sIndex] * potions[pIndex];

            System.out.println(spells[sIndex] + " * " + potions[pIndex] + " = " + multiplication);
            if(multiplication >= success) {
                count++;
           }

            if(pIndex == potions.length - 1) {
                pairs[sIndex++] = count;
                count = 0;
                pIndex = 0;
            } else {
                pIndex++;
            }
        }

        return pairs;
    }

    public int[] successfulPairs1stSolution(int[] spells, int[] potions, long success) {
        int[] successfulPairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            successfulPairs[i] = 0;
            for (int potion : potions) {
                if (((long) spells[i] * potion) >= success) successfulPairs[i]++;
            }
        }

        return successfulPairs;
    }

}
