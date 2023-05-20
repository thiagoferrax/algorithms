package com.trainings.algorithms.arrays;

public class PalindromeIndex {
    public static int palindromeIndex(String s) {
        System.out.println("palindromeIndex " + s);

        //If the word is already a palindrome
        int index = -1;
        if(!isPalindrom(s)) {
            for (int i = 0; i < s.length(); i++) {
                String word = getWordRemovingCharAt(s, i);
                if(isPalindrom(word)) {
                    index =  i;
                    break;
                }
            }
        }

        return index;
    }

    private static String getWordRemovingCharAt(String s, int i) {
        String word = s.substring(0, i);

        if(i + 1 < s.length()) {
            word += s.substring(i+1);
        }

        System.out.println(String.format("This is the %s when removing %d", word, i));

        return word;
    }

    private static boolean isPalindrom(String s) {

        int add = s.length() % 2 == 0 ? 0 : 1;

        String firstPart = s.substring(0, s.length()/2 + add);
        String secondPart = s.substring(s.length()/2);

        System.out.println("firstPart: " + firstPart);
        System.out.println("secondPart: " + secondPart);

        return firstPart.equals(new StringBuilder(secondPart).reverse().toString());
    }
}
