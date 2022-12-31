package com.trainings.algorithms.recursion;

import org.junit.Assert;
import org.junit.Test;


public class PixelPaintTest {

    @Test
    public void test() {
        Assert.assertEquals(10,
                PixelPaint.countPixelsToPaint(new short[][]{{10, 10, 35, 200, 78, 115}, {10, 10, 35, 75, 212, 78},
                        {115, 35, 200, 75, 75, 78}, {212, 112, 75, 75, 75, 75}, {25, 145, 75, 75, 75, 200},
                        {36, 255, 10, 212, 78, 75}, {115, 0, 0, 0, 150, 150}}, 4, 5));
        Assert.assertEquals(10, PixelPaint.countPixelsToPaint(new short[][]{{10, 10, 10, 10, 5},
                {10, 10, 10, 5, 10}, {10, 10, 5, 10, 10}, {10, 5, 10, 10, 10}, {5, 10, 10, 10, 10}}, 1, 1));

    }
}
