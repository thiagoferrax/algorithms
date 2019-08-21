package com.trainings.algorithms.mathematics;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Given the expected and actual return dates for a library book, create a program that calculates the fine (if any).
 * https://www.hackerrank.com/challenges/30-nested-logic/problem
 */
public class NestedLogic {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        Calendar actualDate = getDate(scanner);
        Calendar expected = getDate(scanner);

        int fine = calculateFine(actualDate, expected);
        
        System.out.println(fine);
        
        scanner.close();

    }

	public static int calculateFine(Calendar actual, Calendar expected) {
		int fine = 0;
        if(!actual.before(expected)) {
        	if(sameMonthAndYear(actual, expected)) {
        		fine = 15 * (actual.get(Calendar.DAY_OF_MONTH) - expected.get(Calendar.DAY_OF_MONTH));
        	} else if (sameYear(actual, expected)) {
        		fine = 500 * (actual.get(Calendar.MONTH) - expected.get(Calendar.MONTH));
        	} else {
        		fine = 10000; 
        	}
        }
		return fine;
	}

	private static boolean sameYear(Calendar actual, Calendar expected) {
		return actual.get(Calendar.MONTH) > expected.get(Calendar.MONTH) &&
				actual.get(Calendar.YEAR) == expected.get(Calendar.YEAR);
	}

	private static boolean sameMonthAndYear(Calendar actual, Calendar expected) {
		return actual.get(Calendar.MONTH) == expected.get(Calendar.MONTH) &&
				actual.get(Calendar.YEAR) == expected.get(Calendar.YEAR);
	}

	private static Calendar getDate(Scanner scanner) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, Integer.valueOf(scanner.next()));
        date.set(Calendar.MONTH, Integer.valueOf(scanner.next()) - 1);
        date.set(Calendar.YEAR, Integer.valueOf(scanner.next()));
		return date;
	}
}