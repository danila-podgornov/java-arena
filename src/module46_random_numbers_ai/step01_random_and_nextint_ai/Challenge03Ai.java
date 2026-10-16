// AI-Generated
package module46_random_numbers_ai.step01_random_and_nextint_ai;

import java.util.Random;

public class Challenge03Ai {
    /**
     * A wind card moves your piece anything from 2 squares back to 2 squares ahead. What does this program print? (The 1 in {@code new Random(1)} is a seed, which the next step explains. It doesn't change the answer.)
     * Hints
     * 1. {@code nextInt(5)} gives 0, 1, 2, 3 or 4, never 5. In 10000 draws, each of the five comes up many times.
     * 2. Subtracting 2 moves the whole range down by two.
     */
    public static void main(String[] args) {
        Random random = new Random(1);
        int low = 100;
        int high = -100;
        for (int i = 0; i < 10000; i++) {
            int move = random.nextInt(5) - 2;
            if (move < low) {
                low = move;
            }
            if (move > high) {
                high = move;
            }
        }
        System.out.println(low + " to " + high);
    }
}
