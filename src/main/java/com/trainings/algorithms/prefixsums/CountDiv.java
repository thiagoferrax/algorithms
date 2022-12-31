package com.trainings.algorithms.prefixsums;

/**
 * Compute number of integers divisible by k in range [a..b].
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * Detected time complexity: O(1)
 */
public class CountDiv {
    public int firstSolution(int A, int B, int K) {

        int aSolution = 0;

        int n = 1;
        for (int i = A; i <= B; i += n) {
            if (i % K == 0) {

                if (i != 0) {
                    n = K;
                }

                aSolution++;
            }
        }

        return aSolution;
    }

    // Detected time complexity: O(1)
    public int solution(int A, int B, int K) {

        int aSolution = 0;

        int start = -1;
        int end = 2000000001;
        for (int a = A, b = B; a <= B && b >= A; a++, b--) {
            if (a % K == 0 && start == -1) {
                start = a;
            }
            if (b % K == 0 && end == 2000000001) {
                end = b;
            }

            if (start != -1 && end != 2000000001) {
                return ((end - start) / K) + 1;
            }
        }

        return aSolution;
    }
}
