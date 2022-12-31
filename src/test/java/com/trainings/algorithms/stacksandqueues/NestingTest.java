package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;


public class NestingTest {

    @Test
    public void test() {
        Nesting nesting = new Nesting();

        Assert.assertEquals(1, nesting.solution(""));
        Assert.assertEquals(1, nesting.solution("(()(())())"));
        Assert.assertEquals(0, nesting.solution("())"));
        Assert.assertEquals(0, nesting.solution("(((("));
        Assert.assertEquals(0, nesting.solution(")()("));
        Assert.assertEquals(1, nesting.solution("()(()((())))"));
    }

}
