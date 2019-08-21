package com.trainings.algorithms.arrays;

import java.util.Scanner;

/**
 * Given set S={1, 2, 3, ..., N}. Find two integers, A and B (where A < B), from set S such that the value of A&B is the maximum possible and also less than a given integer, K.
 * https://www.hackerrank.com/challenges/30-bitwise-and/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class BitwiseAND {

	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            String[] nk = scanner.nextLine().split(" ");

	            int n = Integer.parseInt(nk[0]);

	            int k = Integer.parseInt(nk[1]);
	            
	            System.out.println(getMaximumBitwiseAnd(n, k));
	            
	        }

	        scanner.close();
	    }

		public static int getMaximumBitwiseAnd(int n, int k) {
			
			int maximumBitwise = 0;
			for (int i = 1; i <= n - 1; i++) {
				for (int j = i + 1; j <= n; j++) {
					int bitwise = i & j;
					
					if(bitwise < k) {
						maximumBitwise = Math.max(maximumBitwise, bitwise);
					}
				}							
			}			
			
			return maximumBitwise;
		}
	}
