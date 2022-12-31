package com.trainings.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VHChallenge {
    public static List<String> possibilities(String signals) {

        final Map<String, List<String>> signalMap = new HashMap<>();
        signalMap.put("?", List.of("E", "T"));
        signalMap.put("?.", List.of("I", "N"));
        signalMap.put(".?", List.of("I", "A"));
        signalMap.put("?-", List.of("A", "M"));
        signalMap.put("-?", List.of("N", "M"));
        signalMap.put("??", List.of("I", "A", "N", "M"));
        signalMap.put("???", List.of("S", "U", "R", "W", "D", "K", "G", "O"));
        signalMap.put("?..", List.of("S", "D"));
        signalMap.put(".?.", List.of("S", "R"));
        signalMap.put("..?", List.of("S", "U"));
        signalMap.put("??.", List.of("S", "R", "D", "G"));
        signalMap.put("?--", List.of("W", "O"));
        signalMap.put("-?-", List.of("K", "O"));
        signalMap.put("--?", List.of("G", "O"));
        signalMap.put("??-", List.of("U", "W", "K", "O"));
        signalMap.put("?.-", List.of("U", "K"));
        signalMap.put(".", List.of("E"));
        signalMap.put("..", List.of("I"));
        signalMap.put("...", List.of("S"));
        signalMap.put("..-", List.of("U"));
        signalMap.put(".-", List.of("A"));
        signalMap.put(".-.", List.of("R"));
        signalMap.put(".--", List.of("W"));
        signalMap.put("-", List.of("T"));
        signalMap.put("-.", List.of("N"));
        signalMap.put("-..", List.of("D"));
        signalMap.put("-.-", List.of("K"));
        signalMap.put("--", List.of("M"));
        signalMap.put("--.", List.of("G"));
        signalMap.put("---", List.of("O"));
        signalMap.put("?-.", List.of("R", "G"));
        signalMap.put(".?-", List.of("U", "W"));
        signalMap.put("-?.", List.of("D", "G"));
        signalMap.put(".-?", List.of("R", "W"));
        signalMap.put("-.?", List.of("D", "K"));

        System.out.println(signals);

        ArrayList<String> possibilities = new ArrayList<String>();
        if (signalMap.containsKey(signals)) {
            possibilities.addAll(signalMap.get(signals));
        } else {
            System.out.println("Not in the map yet: " + signals);
        }

        return possibilities;
    }
}
