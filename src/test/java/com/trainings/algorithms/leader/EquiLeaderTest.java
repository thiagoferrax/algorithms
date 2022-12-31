package com.trainings.algorithms.leader;

import org.junit.Assert;
import org.junit.Test;


public class EquiLeaderTest {

    @Test
    public void test() {
        EquiLeader equiLeader = new EquiLeader();

        Assert.assertEquals(2, equiLeader.solution(new int[]{4, 3, 4, 4, 4, 2}));
        Assert.assertEquals(1, equiLeader.solution(new int[]{-1000000000, -1000000000}));
    }

}
