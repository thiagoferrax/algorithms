package com.trainings.algorithms.prefixsums;

import org.junit.Assert;
import org.junit.Test;


public class CountDivTest {

    @Test
    public void testFirstSolution() {
        CountDiv countDiv = new CountDiv();

        Assert.assertEquals(3, countDiv.firstSolution(6, 11, 2));
        Assert.assertEquals(5, countDiv.firstSolution(1, 10, 2));
    }

    @Test
    public void test() {
        CountDiv countDiv = new CountDiv();

        //Assert.assertEquals(3, countDiv.solution(6, 11, 2));
        //Assert.assertEquals(5, countDiv.solution(1, 10, 2));
        Assert.assertEquals(1, countDiv.solution(0, 0, 11));
    }

}
