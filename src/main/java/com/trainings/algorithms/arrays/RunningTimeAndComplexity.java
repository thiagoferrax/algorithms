package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * For each number, print whether it is Prime or Not Prime on a new line.
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem
 */
public class RunningTimeAndComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = scanner.nextInt();

        int[] numbers = new int[quantity];
        for (int n = 0; n < quantity; n++) {
            numbers[n] = scanner.nextInt();
        }

        String[] types = isPrime(numbers);

        System.out.println(String.join(System.lineSeparator(), types));

        scanner.close();

    }

    public static String[] isPrime(int[] numbers) {

        Map<Integer, Type> chache = new HashMap<>();
        chache.put(2, Type.PRIME);

        String[] types = new String[numbers.length];

        for (int n = 0; n < numbers.length; n++) {
            types[n] = getType(numbers[n], chache).description;
        }

        return types;
    }

    private static Type getType(int number, Map<Integer, Type> cache) {
        if (number <= 1) {
            return Type.NOT_PRIME;
        }

        if (cache.containsKey(number)) {
            return cache.get(number);
        }

        for (int n = 2; n < number; n++) {
            if (number % n == 0) {
                cache.put(number, Type.NOT_PRIME);
                return Type.NOT_PRIME;
            } else if ((number / n) < n) {
                cache.put(number, Type.PRIME);
                return Type.PRIME;
            }
        }

        cache.put(number, Type.PRIME);
        return Type.PRIME;
    }

    enum Type {
        PRIME("Prime"), NOT_PRIME("Not prime");

        private final String description;

        Type(String description) {
            this.description = description;
        }
    }
}