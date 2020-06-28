package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MakingAnagramsTest {

	@Test
	void test() {
		Assert.assertEquals(3, MakingAnagrams.makeAnagram("cde", "cddf"));
	}
	
	@Test
	void test2() {
		Assert.assertEquals(2, MakingAnagrams.makeAnagram("cdef", "cddf"));
	}
	
	@Test
	void test3() {
		//gdfeabefcdr => abcdeeffgr e abffges => abeffgs => (abcdeeffgr, abeffgs) => abeffg
		Assert.assertEquals(6, MakingAnagrams.makeAnagram("gdfeabefcdr", "abffges"));
	}
	
	@Test
	void test4() {
		Assert.assertEquals(30, MakingAnagrams.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}


}
