package com.trainings.algorithms.arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
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
