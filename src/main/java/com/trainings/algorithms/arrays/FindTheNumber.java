package com.trainings.algorithms.arrays;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an unsorted array of elements, find if the element k is present in the array or not.
 * https://www.hackerrank.com/tests/sample/questions/3lpcngf4s90
 */
public class FindTheNumber {

	    // Complete the findNumber function below.
	    public static String findNumber(List<Integer> arr, int k) {	
	    	Collections.sort(arr);
	    	Collections.binarySearch(arr, k);
	    	return Collections.binarySearch(arr, k) >= 0 ? "YES" : "NO";
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> arrTemp = new ArrayList<>();

	        IntStream.range(0, arrCount).forEach(i -> {
	            try {
	                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        List<Integer> arr = arrTemp.stream()
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(toList());

	        int k = Integer.parseInt(bufferedReader.readLine().trim());

	        String res = findNumber(arr, k);

	        bufferedWriter.write(res);
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}
