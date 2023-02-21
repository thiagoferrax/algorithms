package com.trainings.algorithms.arrays;

public class TrappingRainWater {

	public int trap(int[] height) {
		int max = 0;
		int[] levelWithWater = new int[height.length];		
		for (int i = 0; i < height.length; i++) {
			levelWithWater[i] = getLevelWithWater(height, max, i);
			max = Math.max(max, height[i]);
		}
		
		max = 0;
		int[] levelWithWaterInverse = new int[height.length];	
		for (int i = height.length-1; i >= 0; i--) {
			levelWithWaterInverse[i] = getLevelWithWater(height, max, i);
			max = Math.max(max, height[i]);
		}
		
		int water = 0;
		for (int i = 0; i < height.length; i++) {
			water += Math.min(levelWithWater[i], levelWithWaterInverse[i]) - height[i];
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
