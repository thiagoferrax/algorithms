package com.trainings.algorithms.recursion;

import java.util.Scanner;

/**
 * When a user clicks the mouse over a pixel of an image, the ink can fills all
 * the pixels that have exactly the same color and that are in the
 * 4-neighborhood of the pixel in question and then do so with the pixels
 * painted and so onwards. 
 * https://ucoder.com.br/problems/1006/
 */
public class PixelPaint {
	private static final int COLUMN = 1;
	private static final int ROW = 0;
	private static final int MAX_NEIGHBORS = 4;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int rows = scan.nextInt();
		int columns = scan.nextInt();

		short[][] pixels;
		while (rows != 0 && columns != 0) {

			pixels = new short[rows][columns];

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) {
					pixels[r][c] = scan.nextShort();
				}
			}

			int r = scan.nextInt();
			int c = scan.nextInt();

			System.out.println(getPixelsToPaint(pixels, r, c));

			rows = scan.nextInt();
			columns = scan.nextInt();
		}

		scan.close();
	}

	public static int getPixelsToPaint(short[][] pixels, int r, int c) {

		short[][] paint = new short[pixels.length][pixels.length == 0 ? 0 : pixels[0].length];
		paint[r - 1][c - 1] = 1;

		int[][] neighbors = new int[][] { { r, c } };

		short value = pixels[r - 1][c - 1];

		return addPixelsToPaint(pixels, value, neighbors, paint, 1);
	}

	private static int addPixelsToPaint(short[][] pixels, short value, int[][] neighbors, short[][] paint, int count) {
		int rows = pixels.length;
		int columns = rows > 0 ? pixels[0].length : 0;

		int maxNeighbors = getMaxNeighbors(neighbors);

		int[][] newNeighbors = new int[maxNeighbors][2];

		int neighbor = 0;
		for (int nr = 0; nr < neighbors.length; nr++) {

			if (neighbors[nr][ROW] == 0) {
				continue;
			}

			int r = neighbors[nr][ROW] - 1;
			int c = neighbors[nr][COLUMN] - 1;

			boolean addTop = r - 1 > 0 && pixels[r - 1][c] == value && paint[r - 1][c] != 1;
			if (addTop) {
				paint[r - 1][c] = 1;
				count++;

				newNeighbors[neighbor][ROW] = r;
				newNeighbors[neighbor][COLUMN] = c + 1;
				neighbor++;
			}

			boolean addBottom = r + 1 < rows && pixels[r + 1][c] == value && paint[r + 1][c] != 1;
			if (addBottom) {
				paint[r + 1][c] = 1;
				count++;

				newNeighbors[neighbor][ROW] = r + 2;
				newNeighbors[neighbor][COLUMN] = c + 1;
				neighbor++;
			}

			boolean addLeft = c - 1 > 0 && pixels[r][c - 1] == value && paint[r][c - 1] != 1;
			if (addLeft) {
				paint[r][c - 1] = 1;
				count++;

				newNeighbors[neighbor][ROW] = r + 1;
				newNeighbors[neighbor][COLUMN] = c;
				neighbor++;
			}

			boolean addRight = c + 1 < columns && pixels[r][c + 1] == value && paint[r][c + 1] != 1;
			if (addRight) {
				paint[r][c + 1] = 1;
				count++;

				newNeighbors[neighbor][ROW] = r + 1;
				newNeighbors[neighbor][COLUMN] = c + 2;
				neighbor++;
			}
		}

		if (neighbor > 0) {
			return addPixelsToPaint(pixels, value, newNeighbors, paint, count);
		}

		return count;
	}

	private static int getMaxNeighbors(int[][] neighbors) {
		int maxNeighbors = 0;
		for (int nr = 0; nr < neighbors.length && neighbors[nr][0] != 0; nr++) {
			maxNeighbors++;
		}
		return maxNeighbors * MAX_NEIGHBORS;
	}
}
