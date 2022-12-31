package com.trainings.algorithms.stacksandqueues;

import org.junit.Assert;
import org.junit.Test;


public class FishTest {

    @Test
    public void test() {
        Fish fish = new Fish();
        Assert.assertEquals(1, fish.solution(new int[]{4}, new int[]{1}));
        Assert.assertEquals(1, fish.solution(new int[]{3}, new int[]{0}));

        Assert.assertEquals(1, fish.solution(new int[]{3, 1}, new int[]{1, 0}));
        Assert.assertEquals(1, fish.solution(new int[]{1, 3}, new int[]{1, 0}));
        Assert.assertEquals(2, fish.solution(new int[]{1, 3}, new int[]{0, 1}));
        Assert.assertEquals(2, fish.solution(new int[]{3, 1}, new int[]{0, 1}));

        Assert.assertEquals(2, fish.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        Assert.assertEquals(5, fish.solution(new int[]{4, 3, 2, 6, 5}, new int[]{1, 1, 1, 1, 1}));
        Assert.assertEquals(5, fish.solution(new int[]{4, 3, 2, 6, 5}, new int[]{0, 0, 0, 0, 0}));
        Assert.assertEquals(3, fish.solution(new int[]{4, 7, 2, 6, 5}, new int[]{1, 0, 1, 0, 0}));
        Assert.assertEquals(1, fish.solution(new int[]{4, 3, 2, 1, 0}, new int[]{1, 0, 0, 0, 0}));
        Assert.assertEquals(3, fish.solution(new int[]{1, 2, 3, 4, 5}, new int[]{1, 0, 1, 0, 0}));
        Assert.assertEquals(8, fish.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
        Assert.assertEquals(9, fish.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1}));

        Assert.assertEquals(1, fish.solution(new int[]{5, 3, 4}, new int[]{1, 1, 0}));
        Assert.assertEquals(3, fish.solution(new int[]{4, 3, 2, 6, 5}, new int[]{0, 1, 1, 0, 0}));

    }

}
