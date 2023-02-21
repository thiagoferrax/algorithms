package com.trainings.algorithms.arrays;

public class TrappingRainWater {

	public int trap(int[] height) {
		int maxLeft = 0;
		int[] levelWithWater = new int[height.length];		
		for (int i = 0; i < height.length; i++) {
			levelWithWater[i] = getLevelWithWater(height, maxLeft, i);
			maxLeft = Math.max(maxLeft, height[i]);
		}
		
		int maxRight = 0;
		int water = 0;
		for (int j = height.length-1; j >= 0; j--) {
			water += Math.min(levelWithWater[j], getLevelWithWater(height, maxRight, j)) - height[j];
			maxRight = Math.max(maxRight, height[j]);
		}

		return water;
	}

	private int getLevelWithWater(int[] height, int max, int i) {
		int levelWithWater = height[i];

		if(i != 0 && i != height.length - 1 && max > height[i]) {
			levelWithWater = max;
		}
		
		return levelWithWater;
	}
	
}
