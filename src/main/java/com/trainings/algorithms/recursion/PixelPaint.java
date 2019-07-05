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

			System.out.println(countPixelsToPaint(pixels, r, c));

			rows = scan.nextInt();
			columns = scan.nextInt();
		}

		scan.close();
	}

	public static int countPixelsToPaint(short[][] pixels, int r, int c) {

		int rows = pixels.length;
		int columns = rows == 0 ? 0 : pixels[0].length;

		short[][] paint = new short[rows][columns];
		paintPixel(paint, r - 1, c - 1);
		int count = 1;

		int[][] neighbors = { { r, c } };
		short value = pixels[r - 1][c - 1];

		return addPixelsToPaint(pixels, value, neighbors, paint, count);
	}

	private static int addPixelsToPaint(short[][] pixels, short value, int[][] neighbors, short[][] paint, int count) {

		int[][] newNeighbors = new int[getMaxNeighbors(neighbors)][2];

		int neighborCount = 0;
		for (int[] neighbor : neighbors) {

			if (neighbor[ROW] == 0) {
				continue;
			}

			int r = neighbor[ROW] - 1;
			int c = neighbor[COLUMN] - 1;

			int[][] nearNeighbors = { { r - 1, c }, { r + 1, c }, { r, c - 1 }, { r, c + 1 } };
			for (int[] pixel : nearNeighbors) {
				if (addPixel(pixels, value, paint, newNeighbors, neighborCount, pixel[ROW], pixel[COLUMN])) {
					neighborCount++;
					count++;
				}
			}
		}

		if (neighborCount > 0) {
			return addPixelsToPaint(pixels, value, newNeighbors, paint, count);
		}

		return count;
	}

	private static boolean addPixel(short[][] pixels, short value, short[][] paint, int[][] newNeighbors, int neighbor,
			int row, int column) {
		int rows = pixels.length;
		int columns = rows > 0 ? pixels[0].length : 0;

		boolean add = validPosition(rows, columns, row, column) && pixels[row][column] == value
				&& !isPainted(paint, row, column);
		if (add) {
			paintPixel(paint, row, column);
			addNeighbor(newNeighbors, neighbor, row, column);
		}
		return add;
	}

	private static void addNeighbor(int[][] newNeighbors, int neighbor, int row, int column) {
		newNeighbors[neighbor][ROW] = row + 1;
		newNeighbors[neighbor][COLUMN] = column + 1;
	}

	private static boolean isPainted(short[][] paint, int row, int column) {
		return paint[row][column] == 1;
	}

	private static void paintPixel(short[][] paint, int row, int column) {
		paint[row][column] = 1;
	}

	private static boolean validPosition(int rows, int columns, int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	private static int getMaxNeighbors(int[][] neighbors) {
		int maxNeighbors = 0;
		for (int nr = 0; nr < neighbors.length && neighbors[nr][0] != 0; nr++) {
			maxNeighbors++;
		}
		return maxNeighbors * MAX_NEIGHBORS;
	}
}
