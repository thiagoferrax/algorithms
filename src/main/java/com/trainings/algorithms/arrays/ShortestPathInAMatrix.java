package com.trainings.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/VanHackAcademy/matrix-shortest-path
 */
public class ShortestPathInAMatrix {

    private static Map<String, Integer> getAllPaths(int[][] matrix, int i, int j, String path, int multiplication, Map<String, Integer> pathMultiplicationMap) {

        if (i + 1 < matrix.length) {
            getAllPaths(matrix, i + 1, j, path + "->" + String.valueOf(matrix[i + 1][j]), multiplication * matrix[i + 1][j], pathMultiplicationMap);
        }

        if (j + 1 < matrix[i].length) {
            getAllPaths(matrix, i, j + 1, path + "->" + String.valueOf(matrix[i][j + 1]), multiplication * matrix[i][j + 1], pathMultiplicationMap);
        }

        if (i == matrix.length - 1 && j == matrix[i].length - 1) {
            pathMultiplicationMap.put(path, multiplication);
        }

        return pathMultiplicationMap;
    }

    public String shortestPath(int[][] matrix) {
        // Get all the ways to go from left top to right bottom.
        Map<String, Integer> pathMultiplicationMap = getAllPaths(matrix, 0, 0, String.valueOf(matrix[0][0]), matrix[0][0], new HashMap<>());

        Integer minTrailingZeros = Integer.MAX_VALUE, minMultiplication = Integer.MAX_VALUE;

        String shortestPath = "";
        for (String path : pathMultiplicationMap.keySet()) {
            Integer multiplication = pathMultiplicationMap.get(path);
            Integer trailingZeros = countTrailingZeros(multiplication);

            // Identify the way that has the shortest path (min tailing zeros or min multiplication)
            if (trailingZeros < minTrailingZeros || (trailingZeros == minTrailingZeros && multiplication <= minMultiplication)) {
                minTrailingZeros = trailingZeros;
                minMultiplication = multiplication;
                shortestPath = path;
            }
        }

        return shortestPath;
    }

    private Integer countTrailingZeros(Integer multiplication) {
        String multiplicationString = String.valueOf(multiplication);
        Integer trailingZeros = 0;
        for (int i = multiplicationString.length() - 1; i >= 0; i--) {
            if (multiplicationString.charAt(i) != '0') {
                break;
            } else {
                trailingZeros++;
            }
        }
        return trailingZeros;
    }

}
