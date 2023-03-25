package com.trainings.algorithms.technicaltest;

import java.util.*;

class Occurrence {
    private final String word;
    private Integer count;

    public Occurrence(String word) {
        super();
        this.word = word;
        this.count = 1;
    }

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
        Occurrence other = (Occurrence) obj;
        return word.equals(other.word);
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }

}

/**
 * Find the n words that repeat most in the text.
 */
public class MaxOccurrenceWords {

    public static List<String> findMaxOccurrences(String text, int total) {
        PriorityQueue<Occurrence> queue = new PriorityQueue<>(total, new Comparator<Occurrence>() {
            @Override
            public int compare(Occurrence o1, Occurrence o2) {
                return o1.getCount().compareTo(o2.getCount());
            }
        });

        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> queueMap = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
                if (queue.size() < total) {
                    queue.add(new Occurrence(word));
                    queueMap.put(word, 1);
                }
            } else {
                Integer count = map.get(word) + 1;
                map.put(word, count);

                Integer found = queueMap.get(word);
                if (found != null) {
                    queue.remove(new Occurrence(word));
                    queue.add(new Occurrence(word, count));
                    queueMap.put(word, count);
                } else if (queue.size() < total) {
                    queue.add(new Occurrence(word, count));
                    queueMap.put(word, count);
                } else if (count > queue.peek().getCount()) {
                    Occurrence polled = queue.poll();
                    queue.add(new Occurrence(word, count));

                    queueMap.remove(polled.getWord());
                    queueMap.put(word, count);
                }
            }
        }

        return Arrays.asList(queue.stream().map(o -> o.getWord()).toArray(String[]::new));
    }

}
