package com.trainings.algorithms.strings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class StringBuilderMessagesTest {

    @Test
    void test() {
        assertEquals("m1, m2, m3", StringBuilderMessages.getMessages(Arrays.asList("m1", "m2", "m3")));
    }

}
