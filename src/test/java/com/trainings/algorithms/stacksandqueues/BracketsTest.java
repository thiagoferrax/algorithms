package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;


public class BracketsTest {

    @Test
    public void test() {
        Brackets brackets = new Brackets();
        Assert.assertEquals(1, brackets.solution("{[()()]}"));
        Assert.assertEquals(0, brackets.solution("([)()]"));
        Assert.assertEquals(0, brackets.solution(")("));
        Assert.assertEquals(0, brackets.solution("{{{{"));
    }

}
