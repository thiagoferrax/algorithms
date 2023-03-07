package com.trainings.algorithms.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

class StringBuilderMessagesTest {

    @Test
    void test() {
        assertEquals("m1, m2, m3", StringBuilderMessages.getMessages(Arrays.asList("m1", "m2", "m3")));
    }

}
