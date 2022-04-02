package com.trainings.algorithms.arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class SherlockAndTheValidStringTest {

	@Test
	void testABC() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("abc"));
	}
	
	@Test
	void testAABBCC() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("aabbcc"));
	}
	
	@Test
	void testAABBCCC() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("aabbccc"));
	}
	
	@Test
	void testABABAEBBCCDCDDD() {
		Assert.assertEquals("NO", SherlockAndTheValidString.isValid("ABABAEBBCCDCDDD"));
	}
	
	@Test
	void testAAAAAAA() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("AAAAAAA"));
	}
	
	@Test
	void testABCCBABCA() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("ABCCBABCA"));
	}
	
	@Test
	void testaabbcd() {
		Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aabbcd"));
	}
	
	// aaa bbb cc | aaa bbb c | aa bb ccc | aa bb cccc
	@Test
	void testaaabbbcc() {
		Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aaabbbcc"));
	}
	
	@Test
	void testaaabbbc() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("aaabbbc"));
	}

	@Test
	void testaaabbccc() {
		Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aaabbccc"));
	}
	
	@Test
	void testaaabbcccdd() {
		Assert.assertEquals("NO", SherlockAndTheValidString.isValid("aaabbcccdd"));
	}
	
	@Test
	void testabcc() {
		Assert.assertEquals("YES", SherlockAndTheValidString.isValid("abcc"));
	}
	
}
