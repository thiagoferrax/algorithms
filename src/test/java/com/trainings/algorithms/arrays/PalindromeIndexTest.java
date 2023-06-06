package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeIndexTest {
    @Test
    public void example1() {
        assertEquals(0, new PalindromeIndex().palindromeIndex("bcbc"));
    }

    @Test
    public void example2() {
        assertEquals(0, new PalindromeIndex().palindromeIndex("baa"));
    }
}