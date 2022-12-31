package com.trainings.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class JavaLoopsIITest {

    @Test
    void test() {
        assertEquals("2 6 14 30 62 126 254 510 1022 2046\n8 14 26 50 98",
                JavaLoopsII.calculate(1, new int[][]{{0, 2, 10}, {5, 3, 5}}));
    }

}
