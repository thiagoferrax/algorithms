package com.trainings.algorithms.prefixsums;

/**
 * Find the minimal nucleotide from a range of sequence DNA.
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 */
public class GenomicRangeQuery {
	
	//Detected time complexity: O(N * M)
	public int[] solution(String S, int[] P, int[] Q) {
		int M = P.length;

		int[] aSolution = new int[M];
		for (int m = 0; m < M; m++) {
			char[] range = S.substring(P[m], Q[m] + 1).toCharArray();
			aSolution[m] = getMinimalImpact(range);
		}

		return aSolution;
	}

	private int getMinimalImpact(char[] range) {
		int N = range.length;

		int minimalImpact = 4;
		for (int n = 0; n < N; n++) {
			int impact = getImpact(range, n);
			minimalImpact = Math.min(minimalImpact, impact);
		}

		return minimalImpact;
	}

	private int getImpact(char[] range, int n) {
		int impact;
		switch (range[n]) {
		case 'A':
			impact = 1;
			break;
		case 'C':
			impact = 2;
			break;
		case 'G':
			impact = 3;
			break;
		case 'T':
			impact = 4;
			break;
		default:
			impact = 4;
			break;
		}
		return impact;
	}
}
