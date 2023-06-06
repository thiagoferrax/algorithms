package com.trainings.algorithms.arrays;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/description/">container-with-most-water</a>
 */
public class ContainerWithMostWater {

    private static int getMaxArea(int maxArea, int area1, int area2) {
        if (area2 > area1) {
            if (maxArea < area2) {
                maxArea = area2;
            }
        } else {
            if (maxArea < area1) {
                maxArea = area1;
            }
        }
        return maxArea;
    }

    private static int calculateArea(int[] height, int i, int j) {
        return (j - i) * Math.min(height[j], height[i]);
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int maxArea = 0, left = 0, right = height.length - 1;

        String[] position = {"LEFT", "RIGHT"};

        int count = 0, area1, area2;
        while (left != right) {
            switch (position[count % position.length]) {
                case "LEFT" -> {
                    area1 = calculateArea(height, left, right);
                    area2 = calculateArea(height, left + 1, right);
                    maxArea = getMaxArea(maxArea, area1, area2);
                    left++;
                }
                case "RIGHT" -> {
                    area1 = calculateArea(height, left, right);
                    area2 = calculateArea(height, left, right - 1);
                    maxArea = getMaxArea(maxArea, area1, area2);
                    right--;
                }
            }
            count++;
        }

        return maxArea;
    }

    public int maxAreaFirstSolution(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length - 1; j >= i + 1; j--) {
                int area = calculateArea(height, i, j);
                System.out.println(i + "=h(" + height[i] + "), " + j + "=h(" + height[j] + "), area=" + area);

                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}
