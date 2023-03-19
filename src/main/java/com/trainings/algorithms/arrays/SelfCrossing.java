package com.trainings.algorithms.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/self-crossing/
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        final String[] directions = {"North", "West", "South", "East"};

        int x = 0, y = 0;

        List<Integer> xList = new ArrayList<>(), yList = new ArrayList<>();
        xList.add(x); yList.add(y);

        Set<String> positions = new HashSet<>();
        positions.add(x+","+y);

        boolean selfCrossing = false;

        out: for (int d = 0; d < distance.length; d++) {
            switch (directions[d % directions.length]) {
                case "North":
                    y = y + distance[d];
                    if(!yList.contains(y)) yList.add(y);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                case "West":
                    x = x - distance[d];
                    if(!xList.contains(x)) xList.add(x);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                case "South":
                    y = y - distance[d];
                    if(!yList.contains(y)) yList.add(y);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                case "East":
                    x = x + distance[d];
                    if(!xList.contains(x)) xList.add(x);
                    selfCrossing = !positions.add(x+","+y);
                    if (selfCrossing) break out;
                    break;
                default: throw new IllegalArgumentException("Wrong direction!");
            }
        }

        Collections.sort(xList);
        Collections.sort(yList);

        if(selfCrossing) {
            return true;
        }

        x = 0; y = 0;
        int start, end;

        out:
        for (int i = 0; i < distance.length; i++) {
            switch (directions[i % directions.length]) {
                case "North":
                    start = yList.indexOf(y);
                    end = yList.indexOf(y+distance[i]);

                    for (int north = start + 1; north < end; north++) {
                        selfCrossing = !positions.add(x + "," + yList.get(north));
                        if (selfCrossing) break out;
                    }

                    y += distance[i];
                    break;
                case "West":
                    start = xList.indexOf(x - distance[i]);
                    end = xList.indexOf(x);

                    for (int west = start + 1; west < end; west++) {
                        selfCrossing = !positions.add(xList.get(west) + "," + y);
                        if (selfCrossing) break out;
                    }

                    x -= distance[i];
                    break;
                case "South":
                    start = yList.indexOf(y - distance[i]);
                    end = yList.indexOf(y);

                    for (int south = start + 1; south < end; south++) {
                        selfCrossing = !positions.add(x + "," + yList.get(south));
                        if (selfCrossing) break out;
                    }

                    y -= distance[i];
                    break;
                case "East":
                    start = xList.indexOf(x);
                    end = xList.indexOf(x + distance[i]);

                    for (int east = start + 1; east < end; east++) {
                        selfCrossing = !positions.add(xList.get(east) + "," + y);
                        if (selfCrossing) break out;
                    }

                    x += distance[i];
                    break;
                default: throw new IllegalArgumentException("Wrong direction!");
            }
        }

        return selfCrossing;
    }
}
