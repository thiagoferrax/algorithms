package com.trainings.algorithms.adhoc;

import java.util.Scanner;

/**
 * Given a matrix representing the kangaroos in each enclosure, find out if the
 * composition is correct or, if it is not, for which surrounded the kangaroo
 * has to return.
 * https://ucoder.com.br/problems/1009/
 */
public class Kangaroo {
	private static final int HARMONY = 1;
	private static final int COLUMN = 1;
	private static final int NO_HARMONY = 0;
	private static final int ROW = 0;
	private static final int ROWS = 4;
	private static final int COLUMNS = 4;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int event = scan.nextInt();
		while (event > 0) {

			String toPrint = "Caso " + event + ": ";

			int[][] kangaroos = new int[4][4];

			int[] rK = new int[4];
			int[] cK = new int[4];

			int[][] move = new int[2][2];

			for (int row = 0; row < ROWS; row++) {
				for (int column = 0; column < COLUMNS; column++) {
					kangaroos[row][column] = scan.nextInt();

					if (kangaroos[row][column] == 1) {
						rK[row]++;
						cK[column]++;

						if (rK[row] == 3) {
							move[NO_HARMONY][ROW] = row + 1;
						}

						if (cK[column] == 3) {
							move[NO_HARMONY][COLUMN] = column + 1;
						}
					}
				}
			}

			for (int row = 0; row < ROWS; row++) {
				if (rK[row] == 1) {
					move[HARMONY][ROW] = row + 1;
				}
			}

			for (int column = 0; column < COLUMNS; column++) {
				if (cK[column] == 1) {
					move[HARMONY][COLUMN] = column + 1;
				}
			}

			if (move[NO_HARMONY][ROW] == 0 && move[NO_HARMONY][COLUMN] == 0) {
				toPrint += "CORRETO";
			} else {
				toPrint += "MOVER CANGURU DE (" + move[NO_HARMONY][ROW] + "," + move[NO_HARMONY][COLUMN] + ") PARA ("
						+ move[HARMONY][ROW] + "," + move[HARMONY][COLUMN] + ")";
			}

			System.out.println(toPrint);

			try {
				event = scan.nextInt();
			} catch (Exception e) {
				event = -1;
			}
		}

		scan.close();
	}
}
