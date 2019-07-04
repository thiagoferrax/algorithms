package com.trainings.algorithms.recursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * When a user clicks the mouse over a pixel of an image, the ink can fills all
 * the pixels that have exactly the same color and that are in the
 * 4-neighborhood of the pixel in question and then do so with the pixels
 * painted and so onwards. https://ucoder.com.br/problems/1006/
 */
public class PixelPaint {
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

			System.out.println(getPixelsToPaint(pixels, r - 1, c - 1));

			rows = scan.nextInt();
			columns = scan.nextInt();
		}

		scan.close();
	}

	public static int getPixelsToPaint(short[][] pixels, int r, int c) {
		Set<Pixel> paint = new HashSet<Pixel>();
		Set<Pixel> neighbors = new HashSet<Pixel>();

		Pixel pixel = buildPixel(r, c);
		pixel.value = pixels[r][c];

		paint.add(pixel);
		neighbors.add(pixel);

		addPixelsToPaint(pixels, neighbors, paint);

		return paint.size();
	}

	private static void addPixelsToPaint(short[][] pixels, Set<Pixel> neighbors, Set<Pixel> paint) {
		int rows = pixels.length;
		int columns = rows > 0 ? pixels[0].length : 0;

		Set<Pixel> newNeighbors = new HashSet<PixelPaint.Pixel>();

		for (Pixel pixel : neighbors) {

			int r = pixel.row;
			int c = pixel.column;
			short value = pixel.value;

			Pixel topPixel = buildPixel(r - 1, c);
			boolean addTop = r - 1 > 0 && pixels[r - 1][c] == value && !paint.contains(topPixel);
			if (addTop) {
				topPixel.value = pixels[r - 1][c];
				paint.add(topPixel);
				newNeighbors.add(topPixel);
			}

			Pixel bottomPixel = buildPixel(r + 1, c);
			boolean addBottom = r + 1 < rows && pixels[r + 1][c] == value && !paint.contains(bottomPixel);
			if (addBottom) {
				bottomPixel.value = pixels[r + 1][c];
				paint.add(bottomPixel);
				newNeighbors.add(bottomPixel);
			}

			Pixel leftPixel = buildPixel(r, c - 1);
			boolean addLeft = c - 1 > 0 && pixels[r][c - 1] == value && !paint.contains(leftPixel);
			if (addLeft) {
				leftPixel.value = pixels[r][c - 1];
				paint.add(leftPixel);
				newNeighbors.add(leftPixel);
			}

			Pixel rightPixel = buildPixel(r, c + 1);
			boolean addRight = c + 1 < columns && pixels[r][c + 1] == value && !paint.contains(rightPixel);
			if (addRight) {
				rightPixel.value = pixels[r][c + 1];
				paint.add(rightPixel);
				newNeighbors.add(rightPixel);
			}
		}

		if (!newNeighbors.isEmpty()) {
			addPixelsToPaint(pixels, newNeighbors, paint);
		}
	}

	private static Pixel buildPixel(int r, int c) {
		return new PixelPaint().new Pixel(r, c);
	}

	private class Pixel {
		public Pixel(int row, int column) {
			this.row = row;
			this.column = column;
		}

		private int row;
		private int column;
		private short value;

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
