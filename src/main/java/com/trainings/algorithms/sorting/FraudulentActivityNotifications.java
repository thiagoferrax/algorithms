package com.trainings.algorithms.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FraudulentActivityNotifications {

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		int notifications = 0, trailingDays = 0, count = 0;
		for (int amountDay : expenditure) {
			if (trailingDays < d) {
				priorityQueue.add(amountDay);
			} else if (trailingDays == d) {

				double median = getMedian(priorityQueue);

				if (amountDay >= 2 * median) {
					notifications++;
				}

				priorityQueue.remove(expenditure[count - d]);
				priorityQueue.add(amountDay);
				trailingDays--;
			}

			trailingDays++;
			count++;
		}

		return notifications;
	}

	private static double getMedian(PriorityQueue<Integer> priorityQueue) {
		double median;
		int size = priorityQueue.size();
		if (size % 2 == 0) {
			median = (double) ((int) priorityQueue.toArray()[size / 2] + (int) priorityQueue.toArray()[(size - 1) / 2])
					/ 2;
		} else {
			median = (int) priorityQueue.toArray()[(size / 2)];
		}
		return median;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
