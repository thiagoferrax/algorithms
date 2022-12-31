package com.trainings.algorithms.arrays;

public class AlternatingCharacters {
    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER. The function accepts STRING s
     * as parameter.
     */

    public static int alternatingCharacters(String s) {
        // Write your code here

        int deletions = 0;

        if (s.length() != 0 && s.length() != 1) {
            char[] word = s.toCharArray();

            for (int i = 0; i < word.length - 1; i++) {
                if (word[i + 1] == word[i]) {
                    deletions++;
                }
            }
        }

        return deletions;
    }
}
