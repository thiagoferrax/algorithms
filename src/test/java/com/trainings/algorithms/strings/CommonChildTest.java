package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.Test;


public class CommonChildTest {

    @Test
    public void commonChildABCD_ABDC() {
        Assert.assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
    }

    @Test
    public void childrenOfABCD() {
        Assert.assertEquals("[BC, A, AB, B, AC, ABC, C]", CommonChild.childrenOf("ABC").toString());
    }

    @Test
    public void getChildABC_010() {
        Assert.assertEquals("B", CommonChild.getChild("ABC", new char[]{'0', '1', '0'}));
    }

    @Test
    public void getChildABC_011() {
        Assert.assertEquals("BC", CommonChild.getChild("ABC", new char[]{'0', '1', '1'}));
    }

    @Test
    public void getChildABC_110() {
        Assert.assertEquals("AB", CommonChild.getChild("ABC", new char[]{'1', '1', '0'}));
    }

    @Test
    public void getChildABC_1() {
        Assert.assertEquals("C", CommonChild.getChild("ABC", new char[]{'1'}));
    }

    public void commonChild() {
        Assert.assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
    }
}
