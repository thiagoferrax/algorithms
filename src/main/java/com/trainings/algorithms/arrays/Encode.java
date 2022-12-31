package com.trainings.algorithms.arrays;

/**
 * Simple encode function.
 *
 * @author thiago
 */
public class Encode {

    public String execute(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }

        int i;
        int count = 1;
        char first = word.charAt(0);
        int length = word.length();

        String encoded = "";

        for (i = 1; i < length; i++) {
            if (first == word.charAt(i)) {
                count++;
            } else {
                encoded += "" + count + first;
                count = 1;

                first = word.charAt(i);
            }
        }

        encoded += "" + count + word.charAt(i - 1);

        return encoded;
    }

}
