package com.trainings.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChild {
    public static int commonChild(String s1, String s2) {
        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        int max = 0;
        for (int l = 0; l < s1.length()-1; l++) {
            Map<Character, List<Integer>> map1 = getCharacterListMap(s1);
            Map<Character, List<Integer>> map2 = getCharacterListMap(s2);

            int index = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = l; i < s1.length(); i++) {
                if (map2.containsKey(s1.charAt(i))) {
                    List<Integer> positions = map2.get(s1.charAt(i));
                    for (int j = 0; j < positions.size(); j++) {
                        if (positions.get(j) >= index) {
                            builder.append(s1.charAt(i) + "");
                            index = positions.get(j) + 1;
                            positions.remove(j);
                            break;
                        }
                    }
                    max = Math.max(max, builder.length());
                }
            }
        }
        return max;
    }

    private static Map<Character, List<Integer>> getCharacterListMap(String s1) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            List<Integer> positions = map.getOrDefault(s1.charAt(i), new ArrayList<>());
            positions.add(i);
            map.put(s1.charAt(i), positions);
        }
        return map;
    }

}
