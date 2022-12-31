package com.trainings.algorithms.prefixsums;

import org.junit.Assert;
import org.junit.Test;


public class GenomicRangeQueryTest {

    @Test
    public void test() {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        Assert.assertArrayEquals(new int[]{2, 4, 1}, genomicRangeQuery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }

    @Test
    public void testFirstSolution() {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        Assert.assertArrayEquals(new int[]{2, 4, 1}, genomicRangeQuery.firstSolution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }

    @Test
    public void testReplaceSequence() {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        Assert.assertEquals("1213241", genomicRangeQuery.replaceSequence("AAAACAAAAAGCCTAA"));
    }

}
