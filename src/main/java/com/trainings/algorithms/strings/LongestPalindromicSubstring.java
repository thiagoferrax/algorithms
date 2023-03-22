package com.trainings.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author Thiago
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int maxLength = 0;
        String longestPalindromic = "";

        List<String> allSubstringsOfS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(j+1-i > maxLength) {
                    String substring = s.substring(i, j+1);
                    if(isPalindromeWord(substring)) {
                        maxLength = substring.length();
                        longestPalindromic = substring;
                    }
                }
            }
        }

        return longestPalindromic;
    }

    private boolean isPalindromeWord(String e) {
        return new StringBuilder(e).reverse().toString().equals(e);
    }


    public String longestPalindrome3rdSolution(String s) {
        char[] charArray = s.toCharArray();

        List<String> allSubstrings = getAllSubstrings(s);

        //Filter all of them that are a palindrome

        List<String> allPalindromes = allSubstrings.stream().filter(e -> isPalindromeWord(e)).toList();

        //Pick the biggest palindrome on them
        String longestPalindromic = allPalindromes.stream().max((o1, o2) -> o1.length() - o2.length()).get();

        return longestPalindromic;
    }

    private static List<String> getAllSubstrings(String s) {
        List<String> allSubstringsOfS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                allSubstringsOfS.add(s.substring(i, j+1));
            }
        }
        return allSubstringsOfS;
    }

    public String longestPalindrome2ndSolution(String s) {
    	char[] charArray = s.toCharArray();
    	
    	String maxPalindrom = "" ;
    	for (int i = 0; i < charArray.length; i++) {
    		for (int j = i; j <= charArray.length; j++) {
    			String substring = s.substring(i, j);
    			String reverse = new StringBuilder(substring).reverse().toString();
    			if(substring.equals(reverse)) {
    				if(substring.length() > maxPalindrom.length()) {
    					maxPalindrom = substring;
    				}
    			}
    		}	
		}
    	
    	return maxPalindrom;
    }
	
    public String longestPalindrome1stSolution(String s) {
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
