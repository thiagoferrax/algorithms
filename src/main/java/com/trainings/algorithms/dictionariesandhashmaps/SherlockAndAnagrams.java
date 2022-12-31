package com.trainings.algorithms.dictionariesandhashmaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a string, find the number of pairs of substrings of the string that are
 * anagrams of each other.
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */
public class SherlockAndAnagrams {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int anagrams = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int l = s.length() - 1; l > 0; l--) {
            for (int i = 0; l + i <= s.length(); i++) {
                String substring = s.substring(i, l + i);
                substring = sort(substring);
                if (map.containsKey(substring)) {
                    int count = map.get(substring);
                    map.put(substring, count + 1);
                    anagrams += count;
                } else {
                    map.put(substring, 1);
                }
            }
        }

        return anagrams;
    }

    private static String sort(String substring) {
        if (substring.length() > 0) {
            char[] charArray = substring.toCharArray();
            Arrays.sort(charArray);
            substring = new String(charArray);
        }
        return substring;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}