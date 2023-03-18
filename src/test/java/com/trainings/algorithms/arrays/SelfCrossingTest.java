package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelfCrossingTest {

    @Test
    public void testOne(){
        assertEquals(true, new SelfCrossing().isSelfCrossing(new int[]{2,1,1,2}));
    }

}