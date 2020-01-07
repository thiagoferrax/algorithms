package com.trainings.algorithms.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FraudulentActivityNotifications {

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {

		PriorityQueue<Integer> left = new PriorityQueue<Integer>((arg0, arg1) -> arg1.compareTo(arg0));
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();
		
		int notifications = 0, trailingDays = 0, count = 0;
		Integer median = null;
		for (int amountDay : expenditure) {
			if (trailingDays < d) {
				median = distributeAmounts(left, right, median, amountDay);
			} else if (trailingDays == d) {
				Integer leftBig = left.peek();
				Integer rightSmall = right.peek();
				
				if(d%2==0) {
					
				} else {
					median = getMeanOdd(left, right, median, leftBig, rightSmall);
					notifications = addNotification(notifications, median, amountDay);
					median = removeFirstTrailingDay(expenditure, d, left, right, count, median);
					median = distributeAmounts(left, right, median, amountDay);
				}
				
							
				trailingDays--;
			}

			trailingDays++;
			count++;
		}

		return notifications;
	}

	private static Integer getMeanOdd(PriorityQueue<Integer> left, PriorityQueue<Integer> right, Integer median,
			Integer leftBig, Integer rightSmall) {
		if(leftBig == null) {
			if(median > rightSmall) {
				left.add(right.poll());
			} else {
				left.add(median);
				median = right.poll();
			} 
		} else if(median <= leftBig) {
			Integer previusMedian = median;
			median = left.poll();
			left.add(previusMedian);
		}
		
		if(rightSmall == null) {
			if(median <= leftBig) {
				right.add(left.poll());
			} else {
				right.add(median);
				median = left.poll();
			}
		} else if(median > rightSmall) {
			Integer previusMedian = median;
			median = right.poll();
			right.add(previusMedian);
		}
		return median;
	}

	private static int addNotification(int notifications, Integer median, int amountDay) {
		if (amountDay >= 2 * median) {
			notifications++;
		}
		return notifications;
	}

	private static Integer removeFirstTrailingDay(int[] expenditure, int d, PriorityQueue<Integer> left,
			PriorityQueue<Integer> right, int count, Integer median) {
		int firstTrailingDay = expenditure[count - d];
		if(median == firstTrailingDay) {
			median = null;
		} else if(median <= firstTrailingDay) {
			right.remove(firstTrailingDay);
		} else {
			left.remove(firstTrailingDay);
		}
		return median;
	}

	private static Integer distributeAmounts(PriorityQueue<Integer> left, PriorityQueue<Integer> right, Integer median,
			int amountDay) {
		if(median!=null) {
			if(median <= amountDay) {
				left.add(median);
			} else {
				right.add(median);
			}
		}
		median = amountDay;

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
