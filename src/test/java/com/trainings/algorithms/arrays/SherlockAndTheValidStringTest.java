package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;


public class SherlockAndTheValidStringTest {

    @Test
    public void testABC() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("abc"));
    }

    @Test
    public void testAABBCC() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("aabbcc"));
    }

    @Test
    public void testAABBCCC() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("aabbccc"));
    }

    @Test
    public void testABABAEBBCCDCDDD() {
        Assert.assertEquals("NO", SherlockAndTheValidString.isValid("ABABAEBBCCDCDDD"));
    }

    @Test
    public void testAAAAAAA() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("AAAAAAA"));
    }

    @Test
    public void testABCCBABCA() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("ABCCBABCA"));
    }

    @Test
    public void testaabbcd() {
        Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aabbcd"));
    }

    // aaa bbb cc | aaa bbb c | aa bb ccc | aa bb cccc
    @Test
    public void testaaabbbcc() {
        Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aaabbbcc"));
    }

    @Test
    public void testaaabbbc() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("aaabbbc"));
    }

    @Test
    public void testaaabbccc() {
        Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aaabbccc"));
    }

    @Test
    public void testaaabbcccdd() {
        Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aaabbcccdd"));
    }

    @Test
    public void testabcc() {
        Assert.assertEquals("YES", SherlockAndTheValidString.isValid("abcc"));
    }

}
