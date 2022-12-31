package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

public class EncodeTest {

    @Test
    public void testHappyDay() {
        Assert.assertEquals("3A4B4C8D", new Encode().execute("AAABBBBCCCCDDDDDDDD"));
    }

    @Test
    public void testEmptyString() {
        Assert.assertEquals("", new Encode().execute(""));
    }


    @Test
    public void testWithJustOneCharacter() {
        Assert.assertEquals("1A", new Encode().execute("A"));
    }

    @Test
    public void testWithOneTypeCharacterManyTimes() {
        Assert.assertEquals("8A", new Encode().execute("AAAAAAAA"));
    }

    @Test
    public void testWithNullString() {
        Assert.assertEquals("", new Encode().execute(null));
    }
}
