package com.trainings.algorithms.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbbreviationTest {

    @Test
    public void testHappyDay() {
        assertEquals("YES", Abbreviation.abbreviation("AbcDE", "ABDE"));
    }


    @Test
    public void test_beFgH_EFG() {
        assertEquals("NO", Abbreviation.abbreviation("beFgH", "EFG"));
    }


}
