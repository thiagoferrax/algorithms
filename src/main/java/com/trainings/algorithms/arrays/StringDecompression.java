package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class StringDecompression {

    public char[] decompress(String compressed) {
        Character current = compressed.charAt(0);
        StringBuilder builder = new StringBuilder();
        int counter = 0, quantity = 0;
        while(current != null) {
            if(isANumber(counter, compressed) && quantity == 0) {
                quantity = getWholeNumber(counter, compressed);
                current = compressed.charAt(counter-1);
                counter += String.valueOf(quantity).length() - 1;
                quantity--;
            } else {
                if(quantity > 0) quantity--;
                builder.append(current);
                if(quantity == 0) counter++;
                if(counter < compressed.length() && quantity == 0) {
                    current = compressed.charAt(counter);
                } else if(quantity == 0) {
                    current = null;
                }
            }
        }

        return builder.toString().toCharArray();
    }

    private int getWholeNumber(int counter, String compressed) {
        String number = String.valueOf(compressed.charAt(counter));
        if(isANumber(counter+1, compressed)) {
            number += compressed.charAt(counter+1);
            if(isANumber(counter+2, compressed)) {
                number += compressed.charAt(counter+2);
            }
        }
        return Integer.valueOf(number);
    }

    private boolean isANumber(int counter, String compressed) {
        return counter < compressed.length() && compressed.charAt(counter) >= 48 && compressed.charAt(counter) <= 57;
    }

    public char[] decompress1stSolution(String compressed) {

        int length = compressed.length();
        if (length == 0) {
            return new char[]{};
        } else if (length == 1) {
            return new char[]{compressed.charAt(0)};
        }

        boolean[] numbers = getBooleans(compressed, length);

        Map<Integer, Character> map = new HashMap<>();
        int size = buildMap(compressed, numbers, map);

        return getDecompressedChar(map, size);
    }

    private static char[] getDecompressedChar(Map<Integer, Character> map, int size) {
        char[] decompressed = new char[size];
        Character oldChar = null;
        for (int i = 0; i < size; i++) {
            Character character = map.get(i);
            if (character != null) {
                oldChar = character;
                decompressed[i] = character;
            } else {
                decompressed[i] = oldChar;
            }
        }
        return decompressed;
    }

    private int buildMap(String compressed, boolean[] numbers, Map<Integer, Character> map) {
        int size = 0;
        for (int i = 0; i < numbers.length; i++) {
            char character = compressed.charAt(i);
            if (!numbers[i]) {
                map.put(size, character);
            }
            int number = getNumberAfter(i, compressed, numbers);
            size += number;
            if (number > 1) {
                i += numberOfDigits(number);
            }
        }
        return size;
    }

    private static boolean[] getBooleans(String compressed, int length) {
        boolean[] numbers = new boolean[length];
        for (int i = 0; i < length; i++) {
            char character = compressed.charAt(i);
            numbers[i] = character >= 48 && character <= 57;
        }
        return numbers;
    }

    private int numberOfDigits(int number) {
        return String.valueOf(number).length();
    }

    private int getNumberAfter(int i, String compressedWord, boolean[] numbers) {
        String number = "";
        if (i + 1 < numbers.length && numbers[i + 1]) {
            number += compressedWord.charAt(i + 1);
            if (i + 2 < numbers.length && numbers[i + 2]) {
                number += compressedWord.charAt(i + 2);
                if (i + 3 < numbers.length && numbers[i + 3]) {
                    number += compressedWord.charAt(i + 3);
                }
            }
        }
        return number.isEmpty() ? 1 : Integer.parseInt(number);
    }

}
