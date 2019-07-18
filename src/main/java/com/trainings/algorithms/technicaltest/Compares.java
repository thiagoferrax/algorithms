package com.trainings.algorithms.technicaltest;

import java.util.Arrays;
import java.util.Comparator;

public class Compares {
	public static void main(String[] args) {
		String cities[] = { "B", "P", "S", "N" };
		MySort ms = new MySort();
		
		Arrays.sort(cities, ms);
		System.out.println(Arrays.binarySearch(cities, "N"));	
	}
	
	static class MySort implements Comparator {

		@Override
		public int compare(Object arg0, Object arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}	
