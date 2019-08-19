package com.trainings.algorithms.technicaltest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Occurrence {
	private String word;
	private Integer count;

	public Occurrence(String word, Integer count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Occurrence other = (Occurrence) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return word + ": " + count;
	}
	
	

}

class OccurenceComparator implements Comparator<Occurrence> {

	@Override
	public int compare(Occurrence o1, Occurrence o2) {
		return o1.getCount().compareTo(o2.getCount());
	}

}

public class MaxOccurrenceWords {

	private static final int INITIAL_COUNT = 1;

	public static List<String> findMaxOccurrences(String text, int initialCapacity) {
		PriorityQueue<Occurrence> occurrencesQueue = new PriorityQueue<>(initialCapacity, new OccurenceComparator());

		Map<String, Integer> occurrencesMap = new HashMap<>();

		String[] words = text.split(" ");

		for (String word : words) {
			word = word.toLowerCase();
			if (!occurrencesMap.containsKey(word)) {
				int count = INITIAL_COUNT;
				occurrencesMap.put(word, count);
				addToQueue(initialCapacity, occurrencesQueue, word, count);
			} else {
				Integer count = occurrencesMap.get(word);
				occurrencesMap.put(word, ++count);
				addToQueue(initialCapacity, occurrencesQueue, word, count);
			}
		}

		return getMaxOccurrences(occurrencesQueue);
	}

	private static List<String> getMaxOccurrences(PriorityQueue<Occurrence> occurrencesQueue) {
		List<String> maxOccurrences = new ArrayList<String>();
		Occurrence occurrence = occurrencesQueue.poll();
		while (occurrence != null) {
			maxOccurrences.add(occurrence.getWord());
			occurrence = occurrencesQueue.poll();
		}
		return maxOccurrences;
	}

	private static void addToQueue(int initialCapacity, PriorityQueue<Occurrence> occurrencesQueue, String word,
			int count) {
		Occurrence occurrence = new Occurrence(word, count);

		if (occurrencesQueue.size() < initialCapacity) {
			occurrencesQueue.add(occurrence);
		} else if (count > occurrencesQueue.peek().getCount()) {
			if (!occurrencesQueue.contains(occurrence)) {
				occurrencesQueue.poll();
				occurrencesQueue.add(occurrence);				
			} else {
				Iterator<Occurrence> iterator = occurrencesQueue.iterator();
				Occurrence foundOccurrence = null;
				while (iterator.hasNext()) {
					foundOccurrence = (Occurrence) iterator.next();
					if (foundOccurrence.equals(occurrence)) {
						break;
					}
				}
				occurrencesQueue.remove(foundOccurrence);
				occurrencesQueue.add(new Occurrence(word, count));
			}
		}
	}

}
