package com.trainings.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/self-crossing/
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        final String[] directions = {"North", "West", "South", "East"};

        Set<String> positions = new HashSet<>();
        positions.add("0,0");

        boolean selfCrossing = false;

        int x = 0, y = 0;
        out: for (int i = 0; i < distance.length; i++) {
            int index = i % directions.length;

            switch (directions[index]) {
                case "North":
                    for (int n = y + 1; n <= y + distance[i]; n++) {
                        selfCrossing =  positions.contains(x +","+ n);
                        if(selfCrossing) break out;
                        positions.add(x +","+ n);
                    }
                    y += distance[i];
                    break;
                case "West":
                    for (int w = x - 1; w >= x - distance[i]; w--) {
                        selfCrossing =  positions.contains(w +","+ y);
                        if(selfCrossing) break out;
                        positions.add(w +","+ y);
                    }
                    x -= distance[i];
                    break;
                case "South":
                    for (int s = y - 1; s >= y - distance[i]; s--) {
                        selfCrossing =  positions.contains(x +","+ s);
                        if(selfCrossing) break out;
                        positions.add(x +","+ s);
                    }
                    y -= distance[i];
                    break;
                case "East":
                    for (int e = x + 1; e <= x + distance[i]; e++) {
                        selfCrossing =  positions.contains(e +","+ y);
                        if(selfCrossing) break out;
                        positions.add(e +","+ y);
                    }
                    x += distance[i];
                    break;
                default:
                    throw new IllegalArgumentException("Not expecting a different direction here!");
            }
        }
        return selfCrossing;
    }
}
