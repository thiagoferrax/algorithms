package com.trainings.algorithms.sorting;

/**
 * Determine whether a triangle can be built from a given set of edges.
 * https://app.codility.com/programmers/lessons/6-sorting/
 */
public class Triangle {
    // Detected time complexity: O(N**3)
    public int firstSolution(int[] A) {
        int N = A.length;

        if (N < 3) {
            return 0;
        }

        if (N == 3) {
            return isTriple(A, 0, 1, 2) ? 1 : 0;
        }

        for (int p = 0; p < N - 2; p++) {
            for (int q = p + 1; q < N - 1; q++) {
                for (int r = q + 1; r < N; r++) {
                    if (isTriple(A, p, q, r)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private boolean isTriple(int[] A, int p, int q, int r) {
        return (((float) A[p] + (float) A[q]) > (float) A[r]) && (((float) A[q] + (float) A[r]) > (float) A[p])
                && (((float) A[r] + (float) A[p]) > (float) A[q]);
    }

    // Detected time complexity: O(N**3)
    public int solution(int[] A) {
        return solution(A, 0, A.length - 1);
    }

    private int solution(int[] A, int start, int end) {

        int N = end - start + 1;

        if (N < 3) {
            return 0;
        }

        if (N == 3) {
            return isTriple(A, start, start + 1, start + 2) ? 1 : 0;
        }

        int center = (end - start) / 2;

        if (solution(A, start, center) == 1 || solution(A, start + center + 1, end) == 1) {
            return 1;
        }

        for (int p = start; p <= center; p++) {
            for (int q = p + 1; q <= end - 1; q++) {
                for (int r = q + 1; r <= end; r++) {
                    if (isTriple(A, p, q, r)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

}
