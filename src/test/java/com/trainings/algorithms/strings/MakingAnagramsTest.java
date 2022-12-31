package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.Test;


public class MakingAnagramsTest {

    @Test
    public void test() {
        Assert.assertEquals(3, MakingAnagrams.makeAnagram("cde", "cddf"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, MakingAnagrams.makeAnagram("cdef", "cddf"));
    }

    @Test
    public void test3() {
        //gdfeabefcdr => abcdeeffgr e abffges => abeffgs => (abcdeeffgr, abeffgs) => abeffg
        Assert.assertEquals(6, MakingAnagrams.makeAnagram("gdfeabefcdr", "abffges"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(30, MakingAnagrams.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }


}
