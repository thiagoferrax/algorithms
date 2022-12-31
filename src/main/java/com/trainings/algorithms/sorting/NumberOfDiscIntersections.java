package com.trainings.algorithms.sorting;

/**
 * Compute the number of intersections in a sequence of discs.
 * https://app.codility.com/programmers/lessons/6-sorting/
 */
public class NumberOfDiscIntersections {

    // Detected time complexity: O(N**2)
    public int solution(int[] A) {
        int N = A.length;

        int count = 0;

        for (int n = 0; n < N - 1; n++) {
            float c1Start = getStart(A, n);
            float c1End = getEnd(A, n);
            for (int m = n + 1; m < N; m++) {
                float c2Start = getStart(A, m);
                float c2End = getEnd(A, m);
                if (isIntersection(c1Start, c1End, c2Start, c2End)) {
                    count++;

                    if (count > 10000000) {
                        return -1;
                    }
                }
            }
        }

        return count;
    }

    private float getEnd(int[] A, int n) {
        return (float) n + (float) A[n];
    }

    private float getStart(int[] A, int n) {
        return (float) n - (float) A[n];
    }

    private boolean isIntersection(float c1Start, float c1End, float c2Start, float c2End) {
        return (c1Start <= c2Start && c2End <= c1End) || (c2Start <= c1Start && c1End <= c2End)
                || (c1Start <= c2Start && c1End <= c2End && c1End >= c2Start)
                || (c2Start <= c1Start && c2End <= c1End && c2End >= c1Start);
    }
}
