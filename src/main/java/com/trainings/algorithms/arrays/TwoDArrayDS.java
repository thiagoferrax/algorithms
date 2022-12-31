package com.trainings.algorithms.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Calculate the hourglass sum for every hourglass in arr, then print the
 * maximum hourglass sum.
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class TwoDArrayDS {
    private static final int COLUMN = 1;
    private static final int ROW = 0;

    private static final int[][][] HOURGLASSES = {
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}, {2, 0}, {2, 1}, {2, 2}},
            {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 1}, {2, 2}, {2, 3}},
            {{0, 2}, {0, 3}, {0, 4}, {1, 3}, {2, 2}, {2, 3}, {2, 4}},
            {{0, 3}, {0, 4}, {0, 5}, {1, 4}, {2, 3}, {2, 4}, {2, 5}},

            {{1, 0}, {1, 1}, {1, 2}, {2, 1}, {3, 0}, {3, 1}, {3, 2}},
            {{1, 1}, {1, 2}, {1, 3}, {2, 2}, {3, 1}, {3, 2}, {3, 3}},
            {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 2}, {3, 3}, {3, 4}},
            {{1, 3}, {1, 4}, {1, 5}, {2, 4}, {3, 3}, {3, 4}, {3, 5}},

            {{2, 0}, {2, 1}, {2, 2}, {3, 1}, {4, 0}, {4, 1}, {4, 2}},
            {{2, 1}, {2, 2}, {2, 3}, {3, 2}, {4, 1}, {4, 2}, {4, 3}},
            {{2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 2}, {4, 3}, {4, 4}},
            {{2, 3}, {2, 4}, {2, 5}, {3, 4}, {4, 3}, {4, 4}, {4, 5}},

            {{3, 0}, {3, 1}, {3, 2}, {4, 1}, {5, 0}, {5, 1}, {5, 2}},
            {{3, 1}, {3, 2}, {3, 3}, {4, 2}, {5, 1}, {5, 2}, {5, 3}},
            {{3, 2}, {3, 3}, {3, 4}, {4, 3}, {5, 2}, {5, 3}, {5, 4}},
            {{3, 3}, {3, 4}, {3, 5}, {4, 4}, {5, 3}, {5, 4}, {5, 5}}};
    private static final Scanner scanner = new Scanner(System.in);

    static int hourglassSum(int[][] arr) {
        int[] aSolution = new int[HOURGLASSES.length];
        int maxSum = -63;
        for (int hg = 0; hg < HOURGLASSES.length; hg++) {
            for (int e = 0; e < HOURGLASSES[hg].length; e++) {
                int row = HOURGLASSES[hg][e][ROW];
                int column = HOURGLASSES[hg][e][COLUMN];

                aSolution[hg] += arr[row][column];
            }
            maxSum = Math.max(maxSum, aSolution[hg]);
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
