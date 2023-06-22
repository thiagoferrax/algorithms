package com.trainings.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonChildTest {
    @Test
    public void example1(){
        assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
    }

    @Test
    public void example2(){
        assertEquals(2, CommonChild.commonChild("HARRY", "SALLY"));
    }
    @Test
    public void example3(){
        assertEquals(0, CommonChild.commonChild("AA", "BB"));
    }
    @Test
    public void example4(){
        assertEquals(3, CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
    }
}