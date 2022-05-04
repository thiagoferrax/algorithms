package com.trainings.algorithms.strings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CommonChildTest {
	
	@Test
	void commonChildABCD_ABDC() {
		Assert.assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
	}
	
	@Test
	void childrenOfABCD() {
		Assert.assertEquals("[BC, A, AB, B, AC, ABC, C]", CommonChild.childrenOf("ABC").toString());
	}
	
	@Test
	void getChildABC_010() {
		Assert.assertEquals("B", CommonChild.getChild("ABC", new char[]{'0','1','0'}));
	}
	
	@Test
	void getChildABC_011() {
		Assert.assertEquals("BC", CommonChild.getChild("ABC", new char[]{'0','1','1'}));
	}
	
	@Test
	void getChildABC_110() {
		Assert.assertEquals("AB", CommonChild.getChild("ABC", new char[]{'1','1','0'}));
	}
	
	@Test
	void getChildABC_1() {
		Assert.assertEquals("C", CommonChild.getChild("ABC", new char[]{'1'}));
	}
	
	void commonChild() {
		Assert.assertEquals(3, CommonChild.commonChild("ABCD", "ABDC"));
	}
}
