package com.trainings.algorithms.arrays;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] words) {

        // Create a map with key as ordering the characters of a word and value as a list of words that matches that key.
        Map<String, List<String>> map = new HashMap<>();

        // Iterate the words and then compare the words to
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            List<String> anagrams = map.get(sorted);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                map.put(sorted, anagrams);
            }
            anagrams.add(word);
        }

        List<List<String>> group = new ArrayList<>();
        for (List<String> anagrams : map.values()) {
            group.add(anagrams);
        }

        return group;
    }
}
