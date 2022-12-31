package com.trainings.algorithms.strings;

import java.util.List;

public class StringBuilderMessages {

	public static String getMessages(List<String> asList) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (String msg : asList) {
			if(stringBuilder.length() > 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(msg);
		}
		return stringBuilder.toString();
	}

}
