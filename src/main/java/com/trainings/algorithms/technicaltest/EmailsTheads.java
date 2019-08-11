package com.trainings.algorithms.technicaltest;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Complete the 'getEmailThreads' function below.
 *
 * The function is expected to return a 2D_INTEGER_ARRAY. The function accepts
 * STRING_ARRAY emails as parameter.
 */
class Result {

	private static final int INITIAL_INDEX = 1;
	private static final int THREAD = 0;
	private static final int INDEX = 1;

	public static List<List<Integer>> getEmailThreads(List<String> emails) {
		List<List<Integer>> emailThreads = new ArrayList<List<Integer>>();

		Map<String, Map<String, Integer[]>> emailsMap = new Hashtable<String, Map<String, Integer[]>>();

		int threads = 0;
		for (String email : emails) {
			String[] emailParts = email.split(",");

			String emailKey = getEmailKey(emailParts[0].trim(), emailParts[1].trim());
			String emailSubject = getEmailSubject(emailParts);
			String initialSubject = getInitialSubject(emailSubject);

			if (!emailsMap.containsKey(emailKey)) {
				threads++;

				Map<String, Integer[]> threadsMap = new Hashtable<String, Integer[]>();
				threadsMap.put(initialSubject, new Integer[] { threads, INITIAL_INDEX });
				emailsMap.put(emailKey, threadsMap);
				emailThreads.add(Arrays.asList(threads, INITIAL_INDEX));
			} else {
				Map<String, Integer[]> threadsMap = emailsMap.get(emailKey);

				if (threadsMap.containsKey(initialSubject)) {
					Integer[] threadAndIndex = threadsMap.get(initialSubject);
					threadAndIndex[INDEX]++;
					emailThreads.add(Arrays.asList(threadAndIndex[THREAD], threadAndIndex[INDEX]));
				} else {
					threads++;

					threadsMap.put(initialSubject, new Integer[] { threads, INITIAL_INDEX });
					emailThreads.add(Arrays.asList(threads, INITIAL_INDEX));
				}
			}

		}

		return emailThreads;

	}

	private static String getEmailSubject(String[] emailParts) {
		String emailSubject = emailParts[2];
		for (int i = 3; i < emailParts.length; i++) {
			emailSubject += ",";
			emailSubject += emailParts[i];
		}
		return emailSubject.trim();
	}

	private static String getInitialSubject(String emailSubject) {
		String initialSubject = emailSubject;
		if (emailSubject.contains("---")) {
			String[] subject = emailSubject.split("---");
			initialSubject = subject[subject.length - 1];
		}
		return initialSubject;
	}

	private static String getEmailKey(String email1, String email2) {
		String key = email1 + "_" + email2;
		if (email1.compareTo(email2) < 0) {
			key = email2 + "_" + email1;
		}
		return key;
	}

}

public class EmailsTheads {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int emailsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> emails = IntStream.range(0, emailsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<List<Integer>> result = Result.getEmailThreads(emails);

		result.stream().map(r -> r.stream().map(Object::toString).collect(joining(" "))).map(r -> r + "\n")
				.collect(toList()).forEach(e -> {
					try {
						bufferedWriter.write(e);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
