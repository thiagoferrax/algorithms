package com.trainings.algorithms.arrays;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which
 * reads the same backwards and forwards.
 * https://www.hackerrank.com/challenges/30-queues-stacks/problem
 */
public class Palindrome {

    public boolean isPalindrome(String word) {

        String lowerCaseWord = word.toLowerCase();

        int half = (word.length() / 2) + (word.length() % 2 == 0 ? 0 : 1);
        for (int i = 0; i <= half; i++) {
            if (lowerCaseWord.charAt(i) != lowerCaseWord.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}
