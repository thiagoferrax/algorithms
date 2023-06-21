package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    @Test
    public void example1() {
        assertEquals(true, new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,1}));
    }
}