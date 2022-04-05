package com.trainings.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class SpecialStringAgain {
	
	static long substrCount(int n, String s) {
		return (long) substrCountObj(n, s, new HashMap<String, Boolean>())[0];
	}
	
	static Object[] substrCountObj(int n, String s, Map<String, Boolean> memory) {
		if(memory.containsKey(s)) {
			return new Object[]{0L, memory.get(s)};
		}
		
		long count = 0;
		Boolean special = false;
		
		if(n == 0) {
			return new Object[]{0L, Boolean.TRUE};
		} else if(n == 1) {
			memory.put(s, Boolean.TRUE);
			return new Object[]{1L, Boolean.TRUE};
		}  
		//abba
		if(n % 2 == 0) {
			if (n == 2) {
				int sum = 0;
				sum = getSumIndex(s, memory, sum, 0);
				sum = getSumIndex(s, memory, sum, 1);

				special = s.charAt(0) == s.charAt(1);
				count = special ? 1 + sum : sum;
		
				memory.put(s, special);
				
				return new Object[]{count, special};
			} else {
				long wholeStringSpecial = 0L;
				if(s.charAt(0) == s.charAt(1) && s.charAt(n-1) == s.charAt(n-2)) {
					Object[] response = substrCountObj(n-2, s.substring(1, n-1), memory);
					boolean substringSpecial = ((Boolean)response[1]).equals(Boolean.TRUE);
					if(substringSpecial) {
						wholeStringSpecial++;
					}
					
					memory.put(s, substringSpecial);
					return new Object[]{2 + wholeStringSpecial + (long)response[0], substringSpecial};
				} else {
					Object[] responseA = substrCountObj(n-1, s.substring(1, n), memory);
					Object[] responseB = substrCountObj(n-1, s.substring(0, n-1), memory);
					
					memory.put(s, (Boolean)responseA[1] && (Boolean)responseB[1]);
					return new Object[] {((Long)responseA[0]) + (Long)responseB[0], (Boolean)responseA[1] && (Boolean)responseB[1]};
				}
			}
		} else {
			if (n == 3) {
				int sum = 0;
				sum = getSumIndex(s, memory, sum, 0);
				sum = getSumIndex(s, memory, sum, 1);
				sum = getSumIndex(s, memory, sum, 2);

				special = s.charAt(0) == s.charAt(n-1);
				count += special ? 1 + sum : sum; 
				
				memory.put(s, special);

				return new Object[]{count, special};
			} else {
				Object[] responseA = substrCountObj(n-1, s.substring(1, n), memory);
				Object[] responseB = substrCountObj(n-1, s.substring(0, n-1), memory);
					
				memory.put(s, (Boolean)responseA[1] && (Boolean)responseB[1]);
				return new Object[] {((Long)responseA[0]) + (Long)responseB[0], (Boolean)responseA[1] && (Boolean)responseB[1]};
			}
		}

	}

	private static int getSumIndex(String s, Map<String, Boolean> substrings, int sum, int index) {
		if(!substrings.containsKey(String.valueOf(s.charAt(index)))) {
			substrings.put(String.valueOf(s.charAt(index)), Boolean.TRUE);
			sum++;
		}
		return sum;
	}
	
}
