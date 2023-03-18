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

        boolean selfCrossing = false;

        int x = 0, y = 0;
        out: for (int i = 0; i < distance.length; i++) {
            int index = i%4;
            System.out.println(directions[index]);

            switch (directions[index]) {
                case "North":
                    for (int j = y; j <= y + distance[i]; j++) {
                        if (checkSelfCrossing(positions, x, j)) break out;
                    }
                    y = y + distance[i];
                    break;
                case "West":
                    for (int l = x; l <= x - distance[i]; l--) {
                        if (checkSelfCrossing(positions, l, y)) break out;
                    }
                    x = x - distance[i];
                    break;
                case "South":
                    for (int m = y; m <= y - distance[i]; m--) {
                        if (checkSelfCrossing(positions, x, m)) break out;
                    }
                    y = y - distance[i];
                    break;
                case "East":
                    for (int n = x; n <= x + distance[i]; n++) {
                        if (checkSelfCrossing(positions, n, y)) break out;
                    }
                    x = x + distance[i];
                    break;
                default:
                    throw new IllegalArgumentException("Not expecting a different direction here!");
            }
        }
        return false;
    }

    private static boolean checkSelfCrossing(Set<String> positions, int x, int y) {
        boolean selfCrossing = false;
        String location = x +","+ y;
        if(positions.contains(location)) {
            System.out.println("Self crossing true");
            selfCrossing = true;
        } else {
            System.out.println("Adding location: " + location);
            positions.add(location);
        }
        return selfCrossing;
    }
}
