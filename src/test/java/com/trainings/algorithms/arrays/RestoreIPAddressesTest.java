package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestoreIPAddressesTest {

    @Test
    public void testOne() {
        assertEquals(List.of("255.255.11.135", "255.255.111.35"), new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }

    @Test
    public void testTwo() {
        assertEquals(List.of("0.0.0.0"), new RestoreIPAddresses().restoreIpAddresses("0000"));
    }

    @Test
    public void testThree() {
        assertEquals(List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"), new RestoreIPAddresses().restoreIpAddresses("101023"));
    }
}