package com.trainings.algorithms.arrays;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/self-crossing/">Self Crossing</a> from LeetCode.
 */
public class SelfCrossing {

    private class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + x +
                    ", " + y +
                    '}';
        }
    }

    public boolean isSelfCrossing(int[] distance) {

        final String[] directions = {"North", "West", "South", "East"};

        int x = 0, y = 0;

        List<Position> positions = new ArrayList<>();
        positions.add(new Position(x,y));

        out: for (int d = 0; d < distance.length; d++) {
            switch (directions[d % directions.length]) {
                case "North":
                    y += distance[d];
                    positions.add(new Position(x,y));
                    break;
                case "West":
                    x -= distance[d];
                    positions.add(new Position(x,y));
                    break;
                case "South":
                    y -= distance[d];
                    positions.add(new Position(x,y));
                    break;
                case "East":
                    x += distance[d];
                    positions.add(new Position(x,y));
                    break;
                default: throw new IllegalArgumentException("Wrong direction!");
            }
        }

        System.out.println(positions);

        boolean selfCrossing = false;
        Position pi, piMinus1, piMinus3, piMinus4, piMinus5, piMinus6;

        for (int i = 4; i < positions.size(); i++) {
            pi = positions.get(i);
            piMinus1 = positions.get(i-1);
            piMinus3 = positions.get(i-3);
            piMinus4 = positions.get(i-4);

            selfCrossing = piMinus1.x <= piMinus3.x &&  pi.x >= piMinus4.x && pi.y <= piMinus3.y && pi.y >= piMinus4.y;
            if(selfCrossing) break;

            if(i>=5) {
                piMinus5 = positions.get(i-5);
                selfCrossing = pi.x == piMinus4.x && piMinus1.y <= piMinus4.y && pi.y >= piMinus5.y;
                if(selfCrossing) break;

                if(i>=6) {
                    piMinus6 = positions.get(i-6);
                    selfCrossing = pi.x <= piMinus6.x && piMinus1.x >=piMinus6.x && pi.y >= piMinus6.y && pi.y <= piMinus5.y;
                    if(selfCrossing) break;
                }
            }

        }

        return selfCrossing;
    }

    public boolean isSelfCrossing1stSolution(int[] distance) {
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
