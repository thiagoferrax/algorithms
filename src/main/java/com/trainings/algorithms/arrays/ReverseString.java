package com.trainings.algorithms.arrays;

/**
 * Return a string in reverse order.
 * https://www.udemy.com/master-the-coding-interview-data-structures-algorithms/learn/lecture/12308750#overview
 */
public class ReverseString {
    public String reverse(String word) {
        if (word == null || word.length() < 2) {
            return word;
        }

        char[] reversedWord = new char[word.length()];

        for (int w = word.length() - 1, r = 0; w >= 0; w--, r++) {
            reversedWord[r] = word.charAt(w);
        }

        return new String(reversedWord);
    }
}
