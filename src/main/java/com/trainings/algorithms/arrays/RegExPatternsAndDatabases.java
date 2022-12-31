package com.trainings.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in @gmail.com.
 * https://www.hackerrank.com/challenges/30-regex-patterns/problem?h_r=next-challenge&h_v=zen
 */
public class RegExPatternsAndDatabases {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> firstNames = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            if (emailID.contains("@gmail.com")) {
                firstNames.add(firstName);
            }

        }

        Collections.sort(firstNames);

        System.out.println(String.join(System.lineSeparator(), firstNames));

        scanner.close();
    }
}
