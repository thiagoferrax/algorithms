package com.trainings.algorithms.prefixsums;

import java.util.Arrays;

/**
 * Find the minimal nucleotide from a range of sequence DNA.
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 */
public class GenomicRangeQuery {

	// Detected time complexity: O(N * M)
	public int[] firstSolution(String S, int[] P, int[] Q) {
		int M = P.length;

		int[] aSolution = new int[M];
		for (int m = 0; m < M; m++) {
			String range = S.substring(P[m], Q[m] + 1);
			aSolution[m] = getMinimalImpact(range);
		}

		return aSolution;
	}

	// Detected time complexity: O(N * M)
	public int[] solution(String S, int[] P, int[] Q) {
		int M = P.length;

		int[] aSolution = new int[M];
		char[] sequence = S.toCharArray();
		for (int m = 0; m < M; m++) {
			aSolution[m] = 4;
			for (int n = P[m]; n <= Q[m]; n++) {
				aSolution[m] = Math.min(aSolution[m], getValue(sequence[n]));
				if (aSolution[m] == 1) {
					break;
				}
			}
		}

		return aSolution;
	}

	private int getValue(char c) {
		int value = 4;

		if (c == 'A') {
			value = 1;
		} else if (c == 'C') {
			value = 2;
		} else if (c == 'G') {
			value = 3;
		}

		return value;
	}

	private int getMinimalImpact(String range) {
		char[] sequence = replaceSequence(range).toCharArray();

		Arrays.sort(sequence);

		return Character.getNumericValue(sequence[0]);
	}

	public String replaceSequence(String dnaSequence) {
		return dnaSequence.replaceAll("A+", "1").replaceAll("C+", "2").replaceAll("G+", "3").replaceAll("T+", "4");
	}
}
