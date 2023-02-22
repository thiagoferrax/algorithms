package com.trainings.algorithms.strings;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {

		int left = 0;
		int right = 0;

		for (int i = 0; i < s3.length(); i++) {
			char current = s3.charAt(i);

			boolean leftMatch = left < s1.length() && current == s1.charAt(left);
			boolean rightMatch = right < s2.length() && current == s2.charAt(right);

			if (leftMatch && !rightMatch) {
				left++;
			} else if (!leftMatch && rightMatch) {
				right++;
			} else if (leftMatch && rightMatch) {
				boolean leftWay = left + 1 <= s1.length() && i + 1 < s3.length()
						&& isInterleave(s1.substring(left + 1), s2.substring(right), s3.substring(i + 1));

				if (leftWay) {
					return leftWay;
				} else {
					boolean rightWay = right + 1 <= s2.length() && i + 1 < s3.length()
							&& isInterleave(s1.substring(left), s2.substring(right + 1), s3.substring(i + 1));
					return rightWay;
				}

			} else {
				return false;
			}
		}

		return left == s1.length() && right == s2.length();
	}
}
