package com.trainings.algorithms.arrays;

import junit.framework.TestCase;
import org.junit.Test;

public class CourseScheduleTest extends TestCase {

    @Test
    public void testOne() {
        assertEquals(true, new CourseSchedule().canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    public void testTwo() {
        assertEquals(false, new CourseSchedule().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    public void testThree() {
        assertEquals(false, new CourseSchedule().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
    }
}