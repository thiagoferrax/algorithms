package com.trainings.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : chars) {
            Integer quantity = charMap.get(c);
            if (quantity == null) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, ++quantity);
            }
        }

        return longestPalindrome(s, charMap);
    }

    private String longestPalindrome(String s, Map<Character, Integer> charMap) {
        int left = 0;
        int right = 1;
        char charAtStart = s.charAt(left);
        char charAtEnd = s.charAt(s.length() - right);
        if (charAtStart != charAtEnd) {
            Integer qtyStart = charMap.get(charAtStart);
            Integer qtyEnd = charMap.get(charAtEnd);

            if (qtyStart > 1 && qtyEnd > 1) {
                return leftRightLongestPalindrome(s, charMap, left, right);
            } else {

                if (qtyStart == 1) {
                    left++;
                }
                if (qtyEnd == 1) {
                    right++;
                }

                return longestPalindrome(s.substring(left, s.length() - right + 1), charMap);
            }
        } else {
            if (s.length() <= 3) {
                return charAtStart == charAtEnd ? s : null;
            }

            String between = s.substring(left + 1, s.length() - right);
            if (isPalindrome(between)) {
                return s;
            } else {
                return leftRightLongestPalindrome(s, charMap, left, right);
            }
        }
    }

    private String leftRightLongestPalindrome(String s, Map<Character, Integer> charMap, int left, int right) {
        String leftLongest = longestPalindrome(s.substring(left + 1, s.length() - right), charMap);
        String rightLongest = longestPalindrome(s.substring(left, s.length() - right - 1), charMap);

        if (leftLongest == null) {
            return rightLongest;
        } else if (rightLongest == null) {
            return leftLongest;
        } else {
            return leftLongest.length() >= rightLongest.length() ? leftLongest : rightLongest;
        }
    }

    private boolean isPalindrome(String s) {
        return s.length() <= 1
                || (s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1)));
    }

}
