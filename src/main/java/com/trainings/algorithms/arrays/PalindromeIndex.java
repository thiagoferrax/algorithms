package com.trainings.algorithms.arrays;

public class PalindromeIndex {
    public static int palindromeIndex(String s) {

        String reverse = new StringBuilder(s).reverse().toString();

        //If the word is already a palindrome
        int index = -1;
        if(!isPalindrom(s, reverse)) {
            for (int i = 0; i < s.length(); i++) {
                String word = getWordRemovingCharAt(s, i);
                String reverseWord = getWordRemovingCharAt(reverse, s.length() - 1 - i);

                System.out.printf("The word %s and the reverse word %s.", word, reverseWord);

                if(isPalindrom(word, reverseWord)) {
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

        System.out.printf("This is the %s when removing %d%n", word, i);

        return word;
    }

    private static boolean isPalindrom(String s, String reverse) {

        int add = s.length() % 2 == 0 ? 0 : 1;

        String firstPart = s.substring(0, s.length()/2 + add);
        String secondPart = s.substring(s.length()/2);
        String secondPartReverse = reverse.substring(0, s.length()/2 + add);

        System.out.println("firstPart: " + firstPart);
        System.out.println("secondPart: " + secondPart);
        System.out.println("secondPartReverse: " + secondPartReverse);

        return firstPart.equals(secondPartReverse);
    }
}
