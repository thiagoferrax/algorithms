package com.trainings.algorithms.simulations;

import java.util.Scanner;

/**
 * As he moves and rotates new plates, the ones he has already rotated are
 * losing strength and he has to return quickly so that the plates do not stop
 * spinning, falling and breaking. 
 * https://ucoder.com.br/problems/1004/
 */
public class BalancingDishes {
	private static final int TIME_TO_STOP = 0;
	private static final int CURRENT_TIME = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int nSticks = scan.nextInt();
		int movingTime = scan.nextInt();

		while (nSticks > 0 && movingTime > 0) {
			int index = scan.nextInt() - 1;
			int moves = scan.nextInt();

			int[][] sticks = new int[nSticks][2];

			int time = 0;
			for (int m = 0; m < moves; m++) {
				int nextIndex = scan.nextInt() - 1;
				int strength = scan.nextInt();

				time += getTimeMovingAndRotatingDish(movingTime, index, nextIndex, strength);

				sticks[nextIndex][TIME_TO_STOP] += getTime(strength);
				sticks[nextIndex][CURRENT_TIME] = time;
				
				index = nextIndex;
			}
			
			boolean allDishesMoving = true;
			int minTime = time;
			int minStick = index;
			for (int s = 0; s < nSticks; s++) {
				if(dishWasRotated(sticks, s) && stoppedDish(sticks, time, s)) {
					allDishesMoving = false;
					
					int whenStopped = sticks[s][CURRENT_TIME] + sticks[s][TIME_TO_STOP];
					
					if(whenStopped < minTime) {
						minTime = whenStopped;
						minStick = s;
					}
				} 
			}
			
			System.out.println(allDishesMoving ? "OK" : minTime + " " + (minStick + 1));
			
			nSticks = scan.nextInt();
			movingTime = scan.nextInt();
		}
		
		scan.close();
	}

	private static boolean dishWasRotated(int[][] sticks, int s) {
		return sticks[s][CURRENT_TIME] > 0;
	}

	private static int getTimeMovingAndRotatingDish(int movingTime, int index, int nextIndex, int strength) {
		return (Math.abs(nextIndex - index) * movingTime) + getTime(strength);
	}

	private static boolean stoppedDish(int[][] stickArray, int time, int s) {
		return stickArray[s][TIME_TO_STOP] - (time - stickArray[s][CURRENT_TIME]) <= 0;
	}

	public static int getTime(int strength) {
		return strength * 2;
	}

}
