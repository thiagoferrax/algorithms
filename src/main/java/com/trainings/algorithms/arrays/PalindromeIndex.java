package com.trainings.algorithms.arrays;

public class PalindromeIndex {


    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        int index = -1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                index = isPalindrome(s, left + 1, right) ? left : right;
                break;
            }
            left++;
            right--;
        }

        return index;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        boolean palindrome = true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                palindrome = false;
                break;
            }
            left++;
            right--;
        }

        return palindrome;
    }

    public static int palindromeIndex1stSolution(String s) {

        String reverse = new StringBuilder(s).reverse().toString();

        //If the word is already a palindrome
        int index = -1;
        if (!isPalindrome(s, reverse)) {
            for (int i = 0; i < s.length(); i++) {
                String word = getWordRemovingCharAt(s, i);
                String reverseWord = getWordRemovingCharAt(reverse, s.length() - 1 - i);

                System.out.printf("The word %s and the reverse word %s.", word, reverseWord);

                if (isPalindrome(word, reverseWord)) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    private static String getWordRemovingCharAt(String s, int i) {
        String word = s.substring(0, i);

        if (i + 1 < s.length()) {
            word += s.substring(i + 1);
        }

        System.out.printf("This is the %s when removing %d%n", word, i);

        return word;
    }

    private static boolean isPalindrome(String s, String reverse) {

        int add = s.length() % 2 == 0 ? 0 : 1;

        String firstPart = s.substring(0, s.length() / 2 + add);
        String secondPart = s.substring(s.length() / 2);
        String secondPartReverse = reverse.substring(0, s.length() / 2 + add);

        System.out.println("firstPart: " + firstPart);
        System.out.println("secondPart: " + secondPart);
        System.out.println("secondPartReverse: " + secondPartReverse);

        return firstPart.equals(secondPartReverse);
    }
}
