package com.trainings.algorithms.warmup;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * It must return an array of two integers, the first being Alice's score and the second being Bob's.
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {
    private static final int ALICE = 0;
    private static final int BOB = 1;

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int size = a.size();

        Integer[] points = {0, 0};
        for (int i = 0; i < size; i++) {
            if (a.get(i) > b.get(i)) {
                points[ALICE]++;
            } else if (a.get(i) < b.get(i)) {
                points[BOB]++;
            }
        }

        return Arrays.asList(points);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
