package com.trainings.algorithms.strings;

import java.util.*;

public class SpecialStringAgain {

    static long substrCount2(int n, String s) {
        return buildSubstringMemory(n, s, new HashMap<String, Boolean>(), 0, 0);
    }

    static long buildSubstringMemory(int n, String s, Map<String, Boolean> memory, int index, long count) {
        String key = buildKey(s, index);

        if (memory.containsKey(key) || n == 0) {
            return count;
        }

        if (n == 1) {
            memory.put(key, Boolean.TRUE);
            ++count;
        } else {
            String left = s.substring(0, n - 1);
            String right = s.substring(1, n);
            if (n <= 3) {
                count = buildSubstringMemory(n - 1, left, memory, index, count);
                count = buildSubstringMemory(n - 1, right, memory, index + 1, count);

                boolean special = s.charAt(0) == s.charAt(n - 1);
                memory.put(key, special);

                if (special) {
                    ++count;
                }
            } else {
                count = buildSubstringMemory(n - 1, left, memory, index, count);
                count = buildSubstringMemory(n - 1, right, memory, index + 1, count);

                String substringKey = buildKey(s.substring(1, n - 1), index + 1);

                boolean special = memory.get(substringKey) && s.charAt(0) == s.charAt(1)
                        && s.charAt(n - 2) == s.charAt(n - 1);

                memory.put(key, special);

                if (special) {
                    ++count;
                }
            }
        }

        return count;
    }

    private static String buildKey(String s, int index) {
        return s + "_" + index;
    }

    static long substrCount(int n, String s) {
        List<String> children = getChildren(n, s);

        int count = 0;
        for (String child : children) {
            if (isSpecial(child)) {
                count++;
            }
        }

        return count;
    }

    private static List<String> getChildren(int n, String s) {
        List<String> children = new ArrayList<>();

        for (int jump = 1; jump <= n; jump++) {
            for (int i = 0; i <= n - jump; i += 1) {
                children.add(s.substring(i, i + jump));
            }
        }

        return children;
    }

    public static boolean isSpecial(String s) {
        boolean isSpecial = false;
        int length = s.length();
        boolean even = length % 2 == 0;
        char[] chars = s.toCharArray();

        if (length < 1) {
            isSpecial = true;
        } else if (length == 2) {
            isSpecial = chars[0] == chars[1];
        } else if (even) {
            Arrays.sort(chars);
            isSpecial = chars[0] == chars[length - 1];
        } else {
            char first = chars[0];
            char middle = chars[(length - 1) / 2];
            char last = chars[length - 1];

            Arrays.sort(chars);

            if (chars[0] == chars[length - 1]) {
                isSpecial = true;
            } else if (first != middle && first == last) {
                isSpecial = first < middle
                        ? first == chars[0] && first == chars[length - 2] && middle == chars[length - 1]
                        : middle == chars[0] && first == chars[1] && first == chars[length - 1];
            }
        }

        return isSpecial;
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


}
