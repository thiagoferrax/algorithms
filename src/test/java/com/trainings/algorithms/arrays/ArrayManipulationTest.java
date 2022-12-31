package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayManipulationTest {

    @Test
    public void test() {
        Assert.assertEquals(200L,
                ArrayManipulation.arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
        Assert.assertEquals(70L,
                ArrayManipulation.arrayManipulation(4, new int[][]{{1, 2, 50}, {3, 4, 10}, {1, 4, 20}}));
        Assert.assertEquals(250L,
                ArrayManipulation.arrayManipulation(5, new int[][]{{1, 2, 240}, {3, 4, -20}, {3, 5, 250}}));
        Assert.assertEquals(31L, ArrayManipulation.arrayManipulation(10,
                new int[][]{{2, 6, 8}, {3, 5, 7}, {1, 8, 1}, {5, 9, 15}}));

        Assert.assertEquals(6314L,
                ArrayManipulation.arrayManipulation(100,
                        new int[][]{{19, 28, 419}, {4, 23, 680}, {5, 6, 907}, {19, 33, 582}, {5, 9, 880},
                                {10, 13, 438}, {21, 39, 294}, {13, 18, 678}, {12, 26, 528}, {15, 30, 261},
                                {8, 9, 48}, {21, 23, 131}, {20, 21, 7}, {13, 40, 65}, {13, 23, 901},
                                {15, 15, 914}, {14, 35, 704}, {20, 39, 522}, {10, 18, 379}, {16, 27, 8},
                                {25, 40, 536}, {5, 9, 190}, {17, 20, 809}, {8, 20, 453}, {22, 37, 298},
                                {19, 37, 112}, {2, 5, 186}, {21, 29, 184}, {23, 30, 625}, {2, 8, 960}}));

        Assert.assertEquals(882L,
                ArrayManipulation.arrayManipulation(10, new int[][]{{2, 3, 603}, {1, 1, 286}, {4, 4, 882}}));

    }

    @Test
    public void testHasIntersection() {
        Assert.assertTrue(ArrayManipulation.hasIntersection(new Interval(2, 5, 30), new Interval(1, 3, 20)));
        Assert.assertTrue(ArrayManipulation.hasIntersection(new Interval(2, 5, 30), new Interval(4, 6, 20)));
        Assert.assertTrue(ArrayManipulation.hasIntersection(new Interval(2, 5, 30), new Interval(3, 4, 20)));
        Assert.assertTrue(ArrayManipulation.hasIntersection(new Interval(2, 5, 30), new Interval(5, 7, 20)));
        Assert.assertTrue(ArrayManipulation.hasIntersection(new Interval(5, 7, 30), new Interval(2, 5, 20)));
        Assert.assertFalse(ArrayManipulation.hasIntersection(new Interval(5, 7, 30), new Interval(2, 4, 20)));
        Assert.assertFalse(ArrayManipulation.hasIntersection(new Interval(2, 4, 20), new Interval(5, 7, 30)));
    }

    @Test
    public void testUnionWihIntersection() {

        Comparator<Interval> comparator = new Comparator<Interval>() {

            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.getEnd().compareTo(i2.getEnd());
            }
        };

        PriorityQueue<Interval> priorityQueue = new PriorityQueue<Interval>(comparator);
        priorityQueue.addAll(Arrays.asList(new Interval(1, 1, 20), new Interval(2, 3, 50), new Interval(4, 5, 30)));

        Assert.assertArrayEquals(priorityQueue.toArray(),
                ArrayManipulation.unionWihIntersection(new Interval(2, 5, 30), new Interval(1, 3, 20)).toArray());

        priorityQueue = new PriorityQueue<Interval>(comparator);
        priorityQueue.addAll(Arrays.asList(new Interval(2, 3, 30), new Interval(4, 5, 50), new Interval(6, 6, 20)));

        Assert.assertArrayEquals(priorityQueue.toArray(),
                ArrayManipulation.unionWihIntersection(new Interval(2, 5, 30), new Interval(4, 6, 20)).toArray());

        priorityQueue = new PriorityQueue<Interval>(comparator);
        priorityQueue.addAll(Arrays.asList(new Interval(2, 2, 30), new Interval(3, 4, 50), new Interval(5, 5, 30)));

        Assert.assertArrayEquals(priorityQueue.toArray(),
                ArrayManipulation.unionWihIntersection(new Interval(2, 5, 30), new Interval(3, 4, 20)).toArray());

        priorityQueue = new PriorityQueue<Interval>(comparator);
        priorityQueue.addAll(Arrays.asList(new Interval(2, 4, 30), new Interval(5, 5, 50), new Interval(6, 7, 20)));

        Assert.assertArrayEquals(priorityQueue.toArray(),
                ArrayManipulation.unionWihIntersection(new Interval(2, 5, 30), new Interval(5, 7, 20)).toArray());

    }
}
