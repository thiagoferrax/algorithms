package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class StringDecompression {

    public char[] decompress(String compressed) {
        StringBuilder decompressed = new StringBuilder();
        int counter = 0, quantity = 0;
        Character current = compressed.charAt(0);
        while(current != null) {
            if(isANumber(counter, compressed) && quantity == 0) {
                quantity = getWholeNumber(counter, compressed);
                current = compressed.charAt(counter-1);
                counter += String.valueOf(quantity).length() - 1;
                quantity--;
            } else {
                if(quantity > 0) quantity--;
                decompressed.append(current);
                if(quantity == 0) {
                    if(++counter < compressed.length()) {
                        current = compressed.charAt(counter);
                    } else {
                        current = null;
                    }
                }
            }
        }

        return decompressed.toString().toCharArray();
    }

    private int getWholeNumber(int counter, String compressed) {
        String number = String.valueOf(compressed.charAt(counter));
        if(isANumber(counter+1, compressed)) {
            number += compressed.charAt(counter+1);
            if(isANumber(counter+2, compressed)) {
                number += compressed.charAt(counter+2);
            }
        }
        return Integer.parseInt(number);
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

        Map<Integer, Character> map = new HashMap<>();
        int size = buildMap(compressed, map);

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

    private int buildMap(String compressed, Map<Integer, Character> map) {
        int size = 0;
        for (int i = 0; i < compressed.length(); i++) {
            char character = compressed.charAt(i);
            if (Character.isDigit(character)) {
                map.put(size, character);
            }
            int number = getNumberAfter(i, compressed);
            size += number;
            if (number > 1) {
                i += numberOfDigits(number);
            }
        }
        return size;
    }

    private int numberOfDigits(int number) {
        return String.valueOf(number).length();
    }

    private int getNumberAfter(int i, String compressedWord) {
        int length = compressedWord.length();
        StringBuilder number = new StringBuilder();

        if (i + 1 < length && Character.isDigit(compressedWord.charAt(i+1))) {
            number.append(compressedWord.charAt(i + 1));
            if (i + 2 < length && Character.isDigit(compressedWord.charAt(i+2))) {
                number.append(compressedWord.charAt(i + 2));
                if (i + 3 < length && Character.isDigit(compressedWord.charAt(i+3))) {
                    number.append(compressedWord.charAt(i + 3));
                }
            }
        }
        return number.isEmpty() ? 1 : Integer.parseInt(number.toString());
    }

}
