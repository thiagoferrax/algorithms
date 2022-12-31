package com.trainings.algorithms.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CountingValleys {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        Deque<Character> stack = new ArrayDeque<Character>();

        int valleys = 0;
        boolean isValley = false;
        for (char step : s.toCharArray()) {
            if (!stack.isEmpty() && step != stack.peek()) {
                stack.pop();

                if (isValley && stack.isEmpty()) {
                    valleys++;
                    isValley = false;
                }
            } else {
                if (step == 'D' && stack.isEmpty()) {
                    isValley = true;
                }
                stack.push(step);
            }

        }

        return valleys;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
