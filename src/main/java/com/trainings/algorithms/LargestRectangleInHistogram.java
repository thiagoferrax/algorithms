package com.trainings.algorithms;

import java.util.Arrays;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        //edge case
        int maxAreaJustOneBar = heights[0];
        if (heights.length == 1) {
            return maxAreaJustOneBar;
        }

        int maxAreaJoiningBars = heights[0];
        // Iterate and calculate the maxArea on each index and stay with that max
        for (int i = 1; i < heights.length; i++) {
            maxAreaJustOneBar = Math.max(maxAreaJustOneBar, heights[i]);
            maxAreaJoiningBars = Math.max(maxAreaJoiningBars, calculateJoinAreas(0, i, heights));
        }

        return Math.max(maxAreaJustOneBar, maxAreaJoiningBars);  //Input: heights = [2,0,5,6,2,3]
    }

    public int calculateJoinAreas(int i, int j, int[] heights) {
        int maxAreaJoiningBars = heights[i];
        int minHeight = 100000;

        for (int k = i; k < j; k++) {
            minHeight = Math.min(minHeight, heights[k]);
        }
        maxAreaJoiningBars = Math.max(maxAreaJoiningBars, minHeight * (j - i));

        return maxAreaJoiningBars;
    }
}
