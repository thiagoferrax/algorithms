package com.trainings.algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StringDecompressionTest {

    /*
        decompress_chars_1 = "a3b4a2c"
        decompress_chars_2 = "e3k8"
        decompress_chars_3 = "ab12ek3t6"
        decompress_chars_4 = "ab"

        print("the decompressed string value is", solution.eduardoSol(decompress_chars_1)) # expected answer => ['a', 'a', 'a', 'b', 'b', 'b', 'b', 'a', 'a', 'c']
        print("the decompressed string value is", solution.eduardoSol(decompress_chars_2)) # expected answer => ['e', 'e', 'e', 'k', 'k', 'k', 'k', 'k', 'k', 'k', 'k']
        print("the decompressed string value is", solution.eduardoSol(decompress_chars_3)) # expected answer => ['a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'e', 'k', 'k', 'k', 't', 't', 't', 't', 't', 't'], 't', 't', 't']
        print("the decompressed string value is", solution.eduardoSol(decompress_chars_4)) # expected answer => ['a', 'b']

    */
    @Test
    public void exampleOne() {
        assertEquals("[a, a, a, b, b, b, b, a, a, c]", Arrays.toString(new StringDecompression().decompress("a3b4a2c")));
    }
    @Test
    public void exampleTwo() {
        assertEquals("[e, e, e, k, k, k, k, k, k, k, k]", Arrays.toString(new StringDecompression().decompress("e3k8")));
    }

    @Test
    public void exampleThree() {
        assertEquals("[a, b, b, b, b, b, b, b, b, b, b, b, b, e, k, k, k, t, t, t, t, t, t]", Arrays.toString(new StringDecompression().decompress("ab12ek3t6")));
    }
    @Test
    public void exampleFour() {
        assertEquals("[a, b]", Arrays.toString(new StringDecompression().decompress("ab")));
    }

    @Test
    public void exampleFive() {
        assertEquals("[a, a, b, b, b, b, b, b, b, b, b, b, b, b, b, b, c, c, c, c, c]", Arrays.toString(new StringDecompression().decompress("a2b14c5")));
    }


}