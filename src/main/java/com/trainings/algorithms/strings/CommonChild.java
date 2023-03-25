package com.trainings.algorithms.strings;

import java.util.*;

public class CommonChild {
    public static int commonChild(String s1, String s2) {
        Set<String> common = childrenOf(s1);
        common.retainAll(childrenOf(s2));
        return common.stream().max(Comparator.comparing(s -> s.length())).orElse("").length();
    }

    public static Set<String> childrenOf(String s1) {
        Set<String> children = new HashSet<String>();
        int length = s1.length();

        for (int i = 1; i < Math.pow(2, length); i++) {
            char[] mask = Integer.toBinaryString(i).toCharArray();
            String child = getChild(s1, mask);
            children.add(child);
        }

        return children;
    }

    public static String getChild(String s1, char[] mask) {
        StringBuilder builder = new StringBuilder();
        for (int m = mask.length - 1; m >= 0; m--) {
            if (mask[m] == '1') {
                builder.append(s1.charAt(m + (s1.length() - mask.length)));
            }
        }

        return builder.reverse().toString();
    }

    public static int commonChild2ndSolution(String s1, String s2) {

        Set<Character> set1 = buildSet(s1);
        Set<Character> set2 = buildSet(s2);

        for (char c : set1) {
            if (!set2.contains(c)) {
                s1 = s1.replace(String.valueOf(c), "");
                s2 = s2.replace(String.valueOf(c), "");
            }
        }

        for (char c : set2) {
            if (!set1.contains(c)) {
                s1 = s1.replace(String.valueOf(c), "");
                s1 = s2.replace(String.valueOf(c), "");
            }
        }

        int length = Math.max(s1.length(), s2.length());
        List<Mask> sortedMasks = buildSortedMasks(length);

        Set<String> children1 = new HashSet<String>();
        Set<String> children2 = new HashSet<String>();

        for (Mask mask : sortedMasks) {
            String child1 = getChild2ndSolution(s1, mask.mask);
            children1.add(child1);

            String child2 = getChild2ndSolution(s2, mask.mask);
            children2.add(child2);

            if (children2.contains(child1) || children1.contains(child2)) {
                return mask.size;
            }
        }

        return 0;

    }

    private static Set<Character> buildSet(String s1) {
        Set<Character> set1 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }
        return set1;
    }

    private static List<Mask> buildSortedMasks(int length) {
        List<Mask> masks = new ArrayList<Mask>();
        for (int i = (int) Math.pow(2, length) - 1; i >= 1; i--) {
            masks.add(new Mask(i));
        }

        Collections.sort(masks);
        return masks;
    }

    public static String getChild2ndSolution(String s1, char[] mask) {
        StringBuilder builder = new StringBuilder();

        for (int m = mask.length - 1; m >= 0; m--) {
            if (mask[m] == '1') {
                int index = m + s1.length() - mask.length;
                if (index > 0 && index < s1.length()) {
                    builder.append(s1.charAt(index));
                }
            }
        }

        return builder.reverse().toString();
    }

    static class Mask implements Comparable<Mask> {
        public char[] mask;
        public int size;

        public Mask(int mask) {
            String binaryString = Integer.toBinaryString(mask);
            this.mask = binaryString.toCharArray();
            this.size = binaryString.replace("0", "").length();
        }

        @Override
        public int compareTo(Mask o) {
            return o.size - this.size;
        }

        @Override
        public String toString() {
            return "Mask [mask=" + Arrays.toString(mask) + ", size=" + size + "]";
        }
    }
}
