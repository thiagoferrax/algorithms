package com.trainings.algorithms.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FraudulentActivityNotifications {

	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {

		int maxQueueSize = d / 2;

		PriorityQueue<Integer> left = new PriorityQueue<Integer>(maxQueueSize, (arg0, arg1) -> arg1.compareTo(arg0));
		PriorityQueue<Integer> right = new PriorityQueue<Integer>(maxQueueSize);

		int notifications = 0, trailingDays = 0, count = 0;
		Integer previousAmount = null;
		for (int amountDay : expenditure) {
			if (trailingDays < d) {
				distribute(amountDay, previousAmount, left, right, maxQueueSize);

				previousAmount = amountDay;
			} else if (trailingDays == d) {
				boolean even = d % 2 == 0;

				double median;
				if (even) {
					median = getMedianEven(previousAmount, left, right, maxQueueSize);

					if (isAFraudulentActivity(amountDay, median)) {
						notifications++;
					}

					int firstInElement = expenditure[count - d];
					if (firstInElement > median) {
						right.remove(firstInElement);
					} else {
						left.remove(firstInElement);
					}

				} else {
					median = getMedianOdd(previousAmount, left, right, maxQueueSize);

					if (isAFraudulentActivity(amountDay, median)) {
						notifications++;
					}

					int firstInElement = expenditure[count - d];

					if (firstInElement > median) {
						right.remove(firstInElement);
						right.add((int)median);
					} else if (firstInElement < median) {
						left.remove(firstInElement);
						left.add((int)median);
					}

				}

				previousAmount = amountDay;
				trailingDays--;
			}

			trailingDays++;
			count++;
		}

		return notifications;
	}

	private static boolean isAFraudulentActivity(int amountDay, double median) {
		return amountDay >= 2 * median;
	}

	private static double getMedianOdd(Integer previousAmount, PriorityQueue<Integer> left,
			PriorityQueue<Integer> right, int maxQueueSize) {
		Integer leftBig = left.peek();
		Integer rightSmall = right.peek();

		int median = previousAmount;
		if (leftBig != null && previousAmount <= leftBig) {
			median = left.poll();
			left.add(previousAmount);

			if (rightSmall != null && median > rightSmall) {
				double previousMedian = median;
				median = right.poll();
				right.add((int) previousMedian);
			}

		} else if (rightSmall != null && previousAmount > rightSmall) {
			median = right.poll();
			right.add(previousAmount);

			if (leftBig != null && median <= leftBig) {
				double previousMedian = median;
				median = left.poll();
				left.add((int) previousMedian);
			}
		}
		return median;
	}

	private static double getMedianEven(Integer previousAmount, PriorityQueue<Integer> left,
			PriorityQueue<Integer> right, int maxQueueSize) {
		Integer leftBig = left.peek();
		Integer rightSmall = right.peek();

		double median;
		if (previousAmount > leftBig) {
			if (right.size() < maxQueueSize) {
				right.add(previousAmount);
			} else {
				rightSmall = right.poll();
				left.add(rightSmall);
				right.add(previousAmount);
			}
		} else {
			leftBig = left.poll();
			left.add(previousAmount);
			right.add(leftBig);
		}

		leftBig = left.peek();
		rightSmall = right.peek();

		median = (double) (leftBig + rightSmall) / 2;
		return median;
	}

	private static void distribute(int amountDay, Integer previousAmount, PriorityQueue<Integer> left,
			PriorityQueue<Integer> right, int maxQueueSize) {
		if (previousAmount != null) {
			if (previousAmount > amountDay) {
				if (right.size() < maxQueueSize) {
					right.add(previousAmount);
				} else {
					Integer small = right.peek();
					if (previousAmount > small) {
						small = right.poll();
						right.add(previousAmount);
						left.add(small);
					} else {
						left.add(previousAmount);
					}
				}
			} else {
				if (left.size() < maxQueueSize) {
					left.add(previousAmount);
				} else {
					Integer big = left.peek();
					if (previousAmount <= big) {
						big = left.poll();
						left.add(previousAmount);
						right.add(big);
					} else {
						right.add(previousAmount);
					}
				}
			}
		}
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
