package com.trainings.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
