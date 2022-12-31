package com.trainings.algorithms.prefixsums;

/**
 * Find the minimal average of any slice containing at least two elements.
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 */
public class MinAvgTwoSlice {
    // O(N ** 2)
    public int solution(int[] A) {
        int N = A.length;

        int[] sum = new int[N];
        sum[0] = A[0];

        int aSolution = 0;
        float minSlice = 100000 * 10000;

        for (int n = 0; n < N - 1; n++) {
            for (int m = n + 1; m < N; m++) {
                sum[m] = sum[m - 1] + A[m];

                float sliceNM = (float) (n >= 1 ? sum[m] - sum[n - 1] : sum[m]) / (m - n + 1);

                if (sliceNM < minSlice) {
                    minSlice = sliceNM;
                    aSolution = n;
                }
            }
        }

        return aSolution;
    }

}
