package com.trainings.algorithms.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/self-crossing/
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        final String[] directions = {"North", "West", "South", "East"};

        int x = 0, y = 0;

        Set<Integer> xList = new TreeSet<>(), yList = new TreeSet<>();
        xList.add(x); yList.add(y);

        Set<String> positions = new HashSet<>();
        positions.add(x+","+y);

        boolean selfCrossing = false;

        out: for (int d = 0; d < distance.length; d++) {
            switch (directions[d % directions.length]) {
                case "North":
                    y = y + distance[d];
                    yList.add(y);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                case "West":
                    x = x - distance[d];
                    xList.add(x);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                case "South":
                    y = y - distance[d];
                    yList.add(y);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                case "East":
                    x = x + distance[d];
                    xList.add(x);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                default:
                    throw new IllegalArgumentException("Wrong direction here!");
            }
        }

        if(selfCrossing) {
            return true;
        }

        x = 0;
        y = 0;
        out:
        for (int i = 0; i < distance.length; i++) {
            int index = i % directions.length;

            switch (directions[index]) {
                case "North":
                    for(Integer n : filter(yList, y, y + distance[i])) {
                        selfCrossing = !positions.add(x + "," + n);
                        if (selfCrossing) break out;
                    }
                    y += distance[i];
                    break;
                case "West":
                    for(Integer w : filter(xList, x - distance[i], x)) {
                        selfCrossing = !positions.add(w + "," + y);
                        if (selfCrossing) break out;
                    }
                    x -= distance[i];
                    break;
                case "South":
                    for(Integer s : filter(yList, y - distance[i], y)) {
                        selfCrossing = !positions.add(x + "," + s);
                        if (selfCrossing) break out;
                    }
                    y -= distance[i];
                    break;
                case "East":
                    for(Integer e : filter(xList, x, x  + distance[i])) {
                        selfCrossing = !positions.add(e + "," + y);
                        if (selfCrossing) break out;
                    }
                    x += distance[i];
                    break;
                default:
                    throw new IllegalArgumentException("Wrong direction here!");
            }
        }

        return selfCrossing;
    }

    private static List<Integer> filter(Set<Integer> list, int start, int end) {
        return list.stream().filter(n -> n > start && n < end).toList();
    }
}
