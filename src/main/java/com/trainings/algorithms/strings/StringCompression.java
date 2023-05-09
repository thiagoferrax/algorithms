package com.trainings.algorithms.strings;

/**
 * <a href="https://leetcode.com/problems/string-compression/">...</a>
 */
public class StringCompression {
    public int compress(char[] chars) {

        if(chars.length <= 1 ) {
            return chars.length;
        }

        int count = 1;
        int newArraySize = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            if(chars[i-1] == chars[i]) {
                count++;
            } else {
                if(count!=1) {
                    String countString = String.valueOf(count);
                    sb.append(countString);
                    newArraySize += countString.length();
                }
                sb.append(chars[i]);
                newArraySize++;
                count = 1;
            }
        }

        if(count!=1) {
            String countString = String.valueOf(count);
            sb.append(countString);
            newArraySize += countString.length();
        }

        String newChars = sb.toString();
        for (int i = 0; i < newChars.length(); i++) {
            chars[i] = newChars.charAt(i);
        }

        return newArraySize;
    }
}
