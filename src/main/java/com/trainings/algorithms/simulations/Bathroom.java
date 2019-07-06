package com.trainings.algorithms.simulations;

import java.util.Scanner;

/**
 * Find out how long and which bathroom a certain person in the queue will
 * occupy based on the average time each person takes in the bathroom.
 * https://ucoder.com.br/problems/1008/
 */
public class Bathroom {
	private static final int MAN = 0;
	private static final int WOMAN = 1;
	private static final int GENDER = 2;
	private static final int BATH = 1;
	private static final int TIME = 0;
	private static final int SHOW = 2;
	private static final int MARRIAGE = 1;
	private static final int WOMAN_PROPORTION = 3;
	private static final int MAN_PROPORTION = 2;
	private static final int WOMAN_TIME = 1;
	private static final int MAN_TIME = 0;
	private static final int ANIVERSARY = 0;
	private static final int[][] EVENTS_HISTORY = { { 3, 10, 1, 2 }, { 5, 15, 1, 3 }, { 1, 5, 2, 1 } };
	private static final String[] GENDERS_CODE = { "H", "M" };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int bathrooms = scan.nextInt();
		int queryId = 1;

		while (bathrooms != 0) {
			String event = scan.next();
			int queries = scan.nextInt();

			System.out.println("Consulta " + queryId++ + ":");

			int[] queriesArray = new int[queries];

			int lastPosition = 1;
			for (int q = 0; q < queries; q++) {
				queriesArray[q] = scan.nextInt();
				lastPosition = Math.max(lastPosition, queriesArray[q]);
			}

			int[] eventData = getEventData(event);
			int[] bathsTimes = new int[bathrooms];

			int[][] peopleTimes = new int[lastPosition][3];

			int gender = MAN;
			int countMan = 1;
			int countWoman = 1;
			for (int position = 0; position < lastPosition; position++) {
				int bath = getNextBath(bathsTimes);
				int time = bathsTimes[bath];

				peopleTimes[position][TIME] = time;
				peopleTimes[position][BATH] = bath;
				peopleTimes[position][GENDER] = gender;

				bathsTimes[bath] += getTime(position, gender, eventData);

				if (gender == MAN) {
					if (countMan < eventData[MAN_PROPORTION]) {
						countMan++;
					} else if (countMan == eventData[MAN_PROPORTION]) {
						countMan = 1;
						gender = WOMAN;
					}
				} else {
					if (countWoman < eventData[WOMAN_PROPORTION]) {
						countWoman++;
					} else if (countWoman == eventData[WOMAN_PROPORTION]) {
						countWoman = 1;
						gender = MAN;
					}
				}
			}

			for (int q = 0; q < queries; q++) {
				int position = queriesArray[q] - 1;

				int time = peopleTimes[position][TIME];
				int bathroom = peopleTimes[position][BATH] + 1;
				String genderCode = peopleTimes[position][GENDER] == MAN ? GENDERS_CODE[MAN] : GENDERS_CODE[WOMAN];

				System.out.println(time + " " + bathroom + " " + genderCode);
			}

			bathrooms = scan.nextInt();
		}

		scan.close();
	}

	public static int getNextBath(int[] bathroomTime) {
		int bath = 0;
		int min = bathroomTime[0];
		for (int b = 1; b < bathroomTime.length; b++) {
			if (bathroomTime[b] < min) {
				min = bathroomTime[b];
				bath = b;
			}
		}
		return bath;
	}

	private static int getTime(int position, int gender, int[] event) {
		return gender == MAN ? event[MAN_TIME] : event[WOMAN_TIME];
	}

	private static int[] getEventData(String event) {
		if ("A".equals(event)) {
			return EVENTS_HISTORY[ANIVERSARY];
		}

		if ("C".equals(event)) {
			return EVENTS_HISTORY[MARRIAGE];
		}

		return EVENTS_HISTORY[SHOW];
	}
}
