package com.trainings.algorithms.arrays;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * @author Thiago
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int island = 0;

        int[][] islandsTopDown = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    int nearIsland = getNearIsland(islandsTopDown, i, j);
                    boolean noNearIslandFound = nearIsland == -1;
                    islandsTopDown[i][j] = noNearIslandFound ? ++island : nearIsland;
                    updateNearIslands(grid, islandsTopDown, i, j);
                }
            }
        }

        int[][] islandsBottomUp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] == '1') {
                    int nearIsland = getNearIsland(islandsBottomUp, i, j);
                    boolean noNearIslandFound = nearIsland == -1;
                    islandsBottomUp[i][j] = noNearIslandFound ? ++island : nearIsland;
                    updateNearIslands(grid, islandsBottomUp, i, j);
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
