package com.trainings.algorithms.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

	@Test
	public void test_bb() {
		assertEquals("bb", new LongestPalindromicSubstring().longestPalindrome("bb"));
	}

	@Test
	public void test_a() {
		assertEquals("a", new LongestPalindromicSubstring().longestPalindrome("a"));
	}

	@Test
	public void test() {
		assertEquals("bab", new LongestPalindromicSubstring().longestPalindrome("babad"));
	}

	@Test
	public void test_cbbd() {
		assertEquals("bb", new LongestPalindromicSubstring().longestPalindrome("cbbd"));
	}

	@Test
	public void test_biginput() {
		assertEquals("qosoq", new LongestPalindromicSubstring().longestPalindrome(
				"jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx"));
	}
}
