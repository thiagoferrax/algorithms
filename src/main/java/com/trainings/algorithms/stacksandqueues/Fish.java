package com.trainings.algorithms.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * N voracious fish are moving along a river. Calculate how many fish are alive.
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 * Detected time complexity: O(N)
 */
public class Fish {
    private static final int FLOWING_UPSTREAM = 0;
    private static final int FLOWING_DOWNSTREAM = 1;

    private static final int SIZE = 0;
    private static final int FLOW = 1;

    public int solution(int[] A, int[] B) {
        int N = A.length;

        Deque<Integer[]> alive = new ArrayDeque<>();

        int currentFlow = B[0];
        for (int n = 0; n < N; n++) {
            int nextSize = A[n];
            int nextFlow = B[n];

            if (fishesMeetEachOther(currentFlow, nextFlow)) {
                boolean pushNextFish = true;

                while (!alive.isEmpty() && fishesMeetEachOther(alive.peek()[FLOW], nextFlow) && pushNextFish) {
                    if (alive.peek()[SIZE] < nextSize) {
                        // Current fish is eaten because it is smaller than the next one.
                        alive.pop();
                        pushNextFish = true;
                    } else if (alive.peek()[SIZE] > nextSize) {
                        /*
                         * Current fish is bigger than the next one. There is no need to push a dead
                         * fish in the alive stack.
                         */
                        currentFlow = alive.peek()[FLOW];
                        pushNextFish = false;
                    }
                }

                if (pushNextFish) {
                    alive.push(new Integer[]{nextSize, nextFlow});
                    currentFlow = nextFlow;
                }
            } else {
                alive.push(new Integer[]{nextSize, nextFlow});
                currentFlow = nextFlow;
            }
        }

        return alive.size();
    }

    private boolean fishesMeetEachOther(int currentFlow, int nextFlow) {
        return currentFlow == FLOWING_DOWNSTREAM && nextFlow == FLOWING_UPSTREAM;
    }
}
