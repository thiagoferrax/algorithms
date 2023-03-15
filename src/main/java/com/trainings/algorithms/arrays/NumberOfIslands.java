package com.trainings.algorithms.arrays;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 
 * @author Thiago
 *
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int[][] islands = new int[grid.length][grid[0].length];

		int island = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == '1') {
					int nearIsland = getNearIsland(islands, i, j);
					boolean noNearIslandFound = nearIsland == -1;

					islands[i][j] = noNearIslandFound ? ++island : nearIsland;

					updateNearIslands(grid, islands, i, j);
				}
			}

		}

		return island;
	}

	private void updateNearIslands(char[][] grid, int[][] islands, int i, int j) {
		if (i + 1 < grid.length && grid[i + 1][j] == '1') {
			islands[i + 1][j] = islands[i][j];
		}
		if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
			islands[i][j + 1] = islands[i][j];
			;
		}
	}

	private int getNearIsland(int[][] islands, int i, int j) {
		int nearIsland = -1;

		if (i - 1 >= 0 && islands[i - 1][j] > 0) {
			nearIsland = islands[i - 1][j];
		} else if (i + 1 < islands.length && islands[i + 1][j] > 0) {
			nearIsland = islands[i + 1][j];
		} else if (j - 1 >= 0 && islands[i][j - 1] > 0) {
			nearIsland = islands[i][j - 1];
		} else if (j + 1 < islands[i].length && islands[i][j + 1] > 0) {
			nearIsland = islands[i][j + 1];
		}

		return nearIsland;
	}

}
