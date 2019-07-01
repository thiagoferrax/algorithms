package com.trainings.algorithms.recursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * when a user clicks the mouse over a pixel of an image, the ink can fills all
 * the pixels that have exactly the same color and that are in the
 * 4-neighborhood of the pixel in question and then do so with the pixels
 * painted and so onwards.
 * https://ucoder.com.br/problems/1006/
 */
public class PixelPaint {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int rows = scan.nextInt();
		int columns = scan.nextInt();

		while (rows != 0 && columns != 0) {

			short[][] pixels = new short[rows][columns];

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < columns; c++) {
					pixels[r][c] = scan.nextShort();
				}
			}

			int r = scan.nextInt();
			int c = scan.nextInt();

			System.out.println(getPixelsToPaint(pixels, r - 1, c - 1));

			rows = scan.nextInt();
			columns = scan.nextInt();
		}

		scan.close();
	}

	public static int getPixelsToPaint(short[][] pixels, int r, int c) {
		Set<Pixel> pixelsToPaint = new HashSet<Pixel>();

		addPixelsToPaint(pixels, r, c, pixelsToPaint);

		return pixelsToPaint.size();
	}

	private static void addPixelsToPaint(short[][] pixels, int r, int c, Set<Pixel> pixelsToPaint) {
		Pixel pixel = getPixel(r, c);
		if (!pixelsToPaint.contains(pixel)) {
			pixelsToPaint.add(pixel);
		}

		int value = pixels[r][c];

		int rows = pixels.length;
		int columns = rows > 0 ? pixels[0].length : 0;

		if (r - 1 > 0 && pixels[r - 1][c] == value && !pixelsToPaint.contains(getPixel(r - 1, c))) {
			addPixelsToPaint(pixels, r - 1, c, pixelsToPaint);
		}
		if (r + 1 < rows && pixels[r + 1][c] == value && !pixelsToPaint.contains(getPixel(r + 1, c))) {
			addPixelsToPaint(pixels, r + 1, c, pixelsToPaint);
		}
		if (c - 1 > 0 && pixels[r][c - 1] == value && !pixelsToPaint.contains(getPixel(r, c - 1))) {
			addPixelsToPaint(pixels, r, c - 1, pixelsToPaint);
		}
		if (c + 1 < columns && pixels[r][c + 1] == value && !pixelsToPaint.contains(getPixel(r, c + 1))) {
			addPixelsToPaint(pixels, r, c + 1, pixelsToPaint);
		}
	}

	private static Pixel getPixel(int r, int c) {
		return new PixelPaint().new Pixel(r, c);
	}

	private class Pixel {
		public Pixel(int row, int column) {
			this.row = row;
			this.column = column;
		}

		private int row;
		private int column;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + column;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pixel other = (Pixel) obj;
			if (column != other.column)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}
}
