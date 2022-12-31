package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.Test;


public class SpecialStringAgainTest {

    @Test
    public void testAA() {
        Assert.assertEquals(3, SpecialStringAgain.substrCount(2, "AA"));
    }

    @Test
    public void testABA() {
        Assert.assertEquals(4, SpecialStringAgain.substrCount(3, "ABA"));
    }

    @Test
    public void testasasd() {
        Assert.assertEquals(7, SpecialStringAgain.substrCount(5, "asasd"));
    }

    @Test
    public void testaaaa() {
        Assert.assertEquals(10, SpecialStringAgain.substrCount(4, "aaaa"));
    }

    /*
     * @Test public void testaaaa2ndSolution() { Assert.assertEquals(10,
     * SpecialStringAgain.substrCount2ndSolution(4, "aaaa")); }
     */

    @Test
    public void testisEspecial_aaaa() {
        Assert.assertTrue(SpecialStringAgain.isSpecial("aaaa"));
    }

    @Test
    public void testisEspecial_aabaa() {
        Assert.assertTrue(SpecialStringAgain.isSpecial("aabaa"));
    }

    @Test
    public void testisEspecial_bbabb() {
        Assert.assertTrue(SpecialStringAgain.isSpecial("bbabb"));
    }

    @Test
    public void testisEspecial_cbbabbc() {
        Assert.assertFalse(SpecialStringAgain.isSpecial("cbbabbc"));
    }


}
