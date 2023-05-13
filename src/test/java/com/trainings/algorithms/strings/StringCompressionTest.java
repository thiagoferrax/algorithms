package com.trainings.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCompressionTest {
    @Test
    public void example1() {
        assertEquals(6, new StringCompression().compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    @Test
    public void example2() {
        assertEquals(1, new StringCompression().compress(new char[]{'a'}));
    }
    
    @Test
    public void example3() {
        assertEquals(4, new StringCompression().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}