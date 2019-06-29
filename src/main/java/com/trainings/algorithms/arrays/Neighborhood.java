package com.trainings.algorithms.arrays;

import java.util.Scanner;

/**
 * As a broker interested in selling lots, your problem is not to convince
 * people to buy the land, everyone is willing to stay with anyone, as long as
 * they respect the personal differences that exist among some.
 * https://ucoder.com.br/problems/1003/
 */
public class Neighborhood {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int rows = scan.nextInt();
		int columns = scan.nextInt();

		while (rows != 0 && columns != 0) {

			char[][] lots = new char[rows][columns];

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) {
					lots[r][c] = scan.next().charAt(0);
				}
			}

			System.out.println(isValid(lots, rows, columns) ? "V" : "F");
			
			rows = scan.nextInt();
			columns = scan.nextInt();
		}
		
		scan.close();
	}

	public static boolean isValid(char[][] lots, int rows, int columns) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				switch (lots[r][c]) {
				case 'A':
					if (isNear(lots, rows, columns, r, c, 'B') || isNear(lots, rows, columns, r, c, 'D')) {
						return false;
					}
					break;
				case 'B':
					if (isNear(lots, rows, columns, r, c, 'A') || isNear(lots, rows, columns, r, c, 'C')) {
						return false;
					}
					break;
				case 'D':
					if (isNear(lots, rows, columns, r, c, 'A')) {
						return false;
					}
					break;
				case 'C':
					if (isNear(lots, rows, columns, r, c, 'B')) {
						return false;
					}
					break;
				case 'E':
				case '0':
					// No problems at all.
					break;

				default:
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isNear(char[][] lots, int rows, int columns, int r, int c, char neighbor) {
		return r - 1 > 0 && lots[r - 1][c] == neighbor || r + 1 < rows && lots[r + 1][c] == neighbor
				|| c - 1 > 0 && lots[r][c - 1] == neighbor || c + 1 < columns && lots[r][c + 1] == neighbor;
	}
}
