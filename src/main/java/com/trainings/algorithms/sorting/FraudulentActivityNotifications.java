package com.trainings.algorithms.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * If the amount spent by a client on a particular day is greater than or equal
 * to 2x the client's median spending for a trailing number of days, they send
 * the client a notification about potential fraud.
 * <p>
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */
public class FraudulentActivityNotifications {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int notifications = 0;
        if (expenditure.length <= d) {
            return notifications;
        }

        int[] amounts = new int[201];
        for (int i = 0; i < d; i++) {
            amounts[expenditure[i]]++;
        }

        boolean even = d % 2 == 0;
        for (int i = d; i < expenditure.length; i++) {
            double median = even ? getMedianEven(amounts, d) : getMedianOdd(amounts, d);

            if (isAFraudulentActivity(expenditure[i], median)) {
                notifications++;
            }

            amounts[expenditure[i]]++;
            amounts[expenditure[i - d]]--;
        }

        return notifications;

    }

    private static double getMedianOdd(int[] amounts, int d) {

        int count = 0;
        double median = 0;
        for (int i = 0; i < amounts.length; i++) {
            int amount = amounts[i];
            if (amount > 0) {

                count += amount;
                if (count >= (d / 2) + 1) {
                    median = i;
                    break;
                }

            }
        }
        return median;

    }

    private static double getMedianEven(int[] amounts, int d) {
        int count = 0;

        Integer left = null;
        Integer right = null;

        for (int i = 0; i < amounts.length; i++) {
            Integer amount = amounts[i];

            if (amount > 0) {
                count += amount;

                if (left == null && count >= d / 2) {
                    left = i;
                }

                if (count >= (d / 2) + 1) {
                    right = i;
                    break;
                }

            }
        }
        return (double) (left + right) / 2;
    }

    private static boolean isAFraudulentActivity(int amountDay, double median) {
        return amountDay >= 2 * median;
    }

    static int activityNotificationsFirstSolution(int[] expenditure, int d) {

        int notifications = 0;
        if (expenditure.length <= d) {
            return notifications;
        }

        boolean even = d % 2 == 0;
        int maxQueueSize = Math.max(1, d / 2);

        PriorityQueue<Integer> left = new PriorityQueue<Integer>(maxQueueSize, (arg0, arg1) -> arg1.compareTo(arg0));
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(maxQueueSize);

        Integer previousAmount = null;
        int trailingDays = 0, count = 0;
        for (int amountDay : expenditure) {
            if (trailingDays < d) {
                if (previousAmount != null) {
                    distribute(amountDay, previousAmount, left, right, maxQueueSize);
                }

                previousAmount = amountDay;
            } else if (trailingDays == d) {

                double median;
                if (even) {
                    median = getMedianEven(previousAmount, left, right, maxQueueSize);

                    if (isAFraudulentActivity(amountDay, median)) {
                        notifications++;
                    }

                    int firstInElement = expenditure[count - d];
                    if (right.size() > 0 && firstInElement > median) {
                        right.remove(firstInElement);
                    } else if (left.size() > 0) {
                        left.remove(firstInElement);
                    }

                } else {
                    median = getMedianOdd(previousAmount, left, right, maxQueueSize);

                    if (isAFraudulentActivity(amountDay, median)) {
                        notifications++;
                    }

                    int firstInElement = expenditure[count - d];

                    if (right.size() > 0 && firstInElement > median) {
                        right.remove(firstInElement);
                        right.add((int) median);
                    } else if (left.size() > 0 && firstInElement < median) {
                        left.remove(firstInElement);
                        left.add((int) median);
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

    static int activityNotificationsSecondSolution(int[] expenditure, int d) {

        int notifications = 0;
        if (expenditure.length <= d) {
            return notifications;
        }

        Deque<Integer> analyzedAmounts = new ArrayDeque<Integer>();
        for (int i = 0; i < d; i++) {
            analyzedAmounts.add(expenditure[i]);
        }

        boolean even = d % 2 == 0;
        for (int i = d; i < expenditure.length; i++) {
            Integer[] sortedArray = analyzedAmounts.toArray(new Integer[0]);
            Arrays.sort(sortedArray);

            double median = even ? getMedianEven(d, sortedArray) : getMedianOdd(d, sortedArray);
            if (isAFraudulentActivity(expenditure[i], median)) {
                notifications++;
            }

            analyzedAmounts.pop();
            analyzedAmounts.add(expenditure[i]);
        }
        return notifications;

    }

    private static double getMedianEven(int d, Integer[] sortedArray) {
        return (getMedianOdd(d, sortedArray) + Double.valueOf(String.valueOf(sortedArray[(d / 2) - 1]))) / 2;
    }

    private static Double getMedianOdd(int d, Integer[] sortedArray) {
        return Double.valueOf(String.valueOf(sortedArray[d / 2]));
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
                int previousMedian = median;
                median = right.poll();
                right.add(previousMedian);
            }

        } else if (rightSmall != null && previousAmount > rightSmall) {
            median = right.poll();
            right.add(previousAmount);

            if (leftBig != null && median <= leftBig) {
                int previousMedian = median;
                median = left.poll();
                left.add(previousMedian);
            }
        }
        return median;
    }

    private static double getMedianEven(Integer previousAmount, PriorityQueue<Integer> left,
                                        PriorityQueue<Integer> right, int maxQueueSize) {
        Integer leftBig = left.peek();
        Integer rightSmall = right.peek();

        double median;

        if (leftBig == null) {
            if (previousAmount <= rightSmall) {
                left.add(previousAmount);
            } else {
                rightSmall = right.poll();
                right.add(previousAmount);
                left.add(rightSmall);
            }
        } else if (rightSmall == null) {
            if (previousAmount > leftBig) {
                right.add(previousAmount);
            } else {
                leftBig = left.poll();
                left.add(previousAmount);
                right.add(leftBig);
            }
        } else if (previousAmount > leftBig) {
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
