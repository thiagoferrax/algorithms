package com.trainings.algorithms.stacksandqueues;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[', '],
 * '<' and '>' in an unordered form "{[><(])((}))" determine if the input string
 * is valid
 * <p>
 * Valid means - an open bracket has its corresponding closing bracket within
 * the string
 * <p>
 * Bonus Question....arrange the brackets
 * <p>
 * arrange brackets meaning ============================ the result value is
 * formed by this... 1. confirm that the string is valid by ensuring that each
 * opening bracket has a corresponding closing bracket 2. the first complete
 * bracket found is added to the result value 3. subsequent complete bracket
 * will wrap the current result value e.g. if the first complete bracket is
 * "()", then the result value will be "()"...if the next complete bracket found
 * is "<>"...then the new result value will be "<()>"
 * <p>
 * ([{])} // input = "{[><(])((}))" to end up like # "(({([<>])}))"
 * <p>
 * <p>
 * stack {
 *
 * @author thiago
 */
public class ArrangeTheBrackets {

    public static boolean isValid(final String unordered) {

        if (unordered.length() < 2 || unordered.length() % 2 == 1) {
            return false;
        }
        final Map<Character, Character> pairs = buildPairs();

        char[] charArray = unordered.toCharArray();

        final Map<Character, Integer> charQuantityMap = new HashMap<>();

        for (char c : charArray) {
            Character match = pairs.get(c);
            Integer matchQuantity = charQuantityMap.get(match);
            boolean foundAMatch = matchQuantity != null;
            if (foundAMatch) {
                if (--matchQuantity == 0) {
                    charQuantityMap.remove(match);
                } else {
                    charQuantityMap.replace(match, matchQuantity);
                }
            } else {
                Integer quantity = charQuantityMap.get(c);
                charQuantityMap.put(c, quantity == null ? 1 : ++quantity);
            }
        }

        return charQuantityMap.isEmpty();
    }

    private static Map<Character, Character> buildPairs() {
        final Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put('(', ')');
        pairs.put('<', '>');
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');
        pairs.put('>', '<');
        return pairs;
    }

    private static Map<Character, String> buildMatchPairs() {
        final Map<Character, String> pairs = new HashMap<>();
        pairs.put('{', "{}");
        pairs.put('[', "[]");
        pairs.put('(', "()");
        pairs.put('<', "<>");
        pairs.put('}', "{}");
        pairs.put(']', "[]");
        pairs.put(')', "()");
        pairs.put('>', "<>");
        return pairs;
    }


    public static String order(String unordered) {

        if (!isValid(unordered)) {
            return null;
        }
        StringBuilder ordered = new StringBuilder();

        final Map<Character, Character> pairs = buildPairs();
        final Map<Character, String> matchPairs = buildMatchPairs();

        char[] charArray = unordered.toCharArray();

        final Map<Character, Integer> charQuantityMap = new HashMap<>();
        for (char c : charArray) {
            Character match = pairs.get(c);
            Integer matchQuantity = charQuantityMap.get(match);
            boolean foundAMatch = matchQuantity != null;
            if (foundAMatch) {
                String matchPair = matchPairs.get(match);
                ordered.insert(0, matchPair.charAt(0));
                ordered.append(matchPair.charAt(1));

                if (--matchQuantity == 0) {
                    charQuantityMap.remove(match);
                } else {
                    charQuantityMap.replace(match, matchQuantity);
                }
            } else {
                Integer quantity = charQuantityMap.get(c);
                charQuantityMap.put(c, quantity == null ? 1 : ++quantity);
            }
        }

        return ordered.toString();
    }

}
