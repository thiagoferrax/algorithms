package com.trainings.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringDecompression {
    public char[] decompress(String compressed) {

        int length = compressed.length();
        if (length == 0) {
            return new char[]{};
        } else if (length == 1) {
            return new char[]{compressed.charAt(0)};
        }

        boolean[] numbers = new boolean[length];
        for (int i = 0; i < length; i++) {
            char character = compressed.charAt(i);
            numbers[i] = character >= 48 && character <= 57;
        }

        Map<Integer, Character> map = new HashMap<>();
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
