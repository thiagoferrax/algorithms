package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelfCrossingTest {

    @Test
    public void testOne(){
        assertEquals(true, new SelfCrossing().isSelfCrossing(new int[]{2,1,1,2}));
    }

    @Test
    public void testTwo(){
        assertEquals(false, new SelfCrossing().isSelfCrossing(new int[]{1,2,3,4}));
    }

    @Test
    public void testThree(){
        assertEquals(true, new SelfCrossing().isSelfCrossing(new int[]{1,1,1,2,1}));
    }


}