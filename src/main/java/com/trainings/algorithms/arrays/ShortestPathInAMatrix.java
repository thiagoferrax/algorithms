package com.trainings.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/VanHackAcademy/matrix-shortest-path
 */
public class ShortestPathInAMatrix {

    public String shortestPath(int[][] matrix) {
        // Get all the ways to go from left top to right bottom.
        List<String> paths = getAllPaths(matrix, String.valueOf(matrix[0][0]), 0,0, new ArrayList<>());

        Integer minTrailingZeros = Integer.MAX_VALUE, minMultiplication = Integer.MAX_VALUE;

        String shortestPath = "";
        for (String path: paths) {
            Integer multiplication = getMultiplication(path);
            Integer trailingZeros = countTrailingZeros(multiplication);

            // Identify the way that has the shortest path (min tailing zeros or min multiplication)
            if(trailingZeros < minTrailingZeros || (trailingZeros == minTrailingZeros && multiplication <= minMultiplication)) {
                minTrailingZeros = trailingZeros;
                minMultiplication = multiplication;
                shortestPath = path;
            }
        }

        return shortestPath;
    }

    private static Integer getMultiplication(String path) {
        String[] split = path.split("->");
        Integer multiplication = 1;
        for (String element: split) {
            multiplication *= Integer.valueOf(element);
        }
        return multiplication;
    }

    private Integer countTrailingZeros(Integer multiplication) {
        char[] chars = String.valueOf(multiplication).toCharArray();
        Integer trailingZeros = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i]!='0') {
                break;
            } else {
                trailingZeros++;
            }
        }
        return trailingZeros;
    }

    private static List<String> getAllPaths(int[][] matrix, String element, int i, int j, List<String> paths) {

        if(i + 1 < matrix.length) {
            getAllPaths(matrix, element + "->" + String.valueOf(matrix[i+1][j]), i+1, j, paths);
        }
        if(j + 1 < matrix[i].length) {
            getAllPaths(matrix, element + "->" + String.valueOf(matrix[i][j+1]), i, j+1, paths);
        }
        if(i==matrix.length-1 && j == matrix[i].length -1) {
            paths.add(element);
        }

        return paths;
    }

}
