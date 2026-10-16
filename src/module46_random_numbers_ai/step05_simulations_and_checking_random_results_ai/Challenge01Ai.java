// AI-Generated
package module46_random_numbers_ai.step05_simulations_and_checking_random_results_ai;

import java.util.Random;

public class Challenge01Ai {
    /**
     * A coin flip streak counter. Write the method {@code longestStreak(Random random, int flips)}, which flips a coin {@code flips} times and returns the longest streak: the most flips in a row that landed on the same side. Flip each coin with one {@code random.nextBoolean()} call ({@code true} is heads, {@code false} is tails), so that a seed gives the same flips as the check's. {@code flips} is at least 1. For example, the flips heads, tails, tails, tails, heads have a longest streak of 3. The check runs:
     * <pre>{@code
     * Random random = new Random(42);
     * System.out.println(longestStreak(random, 10));
     * System.out.println(longestStreak(random, 100));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * 6
     * }</pre>
     * Hints
     * 1. Flip the first coin before the loop, and keep it in {@code previous}. The streak so far is 1, and so is the longest one.
     * 2. Loop for the other {@code flips - 1} coins. When a flip is the same as {@code previous}, the streak grows; otherwise it starts again at 1. Update the longest streak, and remember the flip in {@code previous} for the next round.
     */
    public static void main(String[] args) {
        Random random = new Random(42);
        System.out.println(longestStreak(random, 10));
        System.out.println(longestStreak(random, 100));
    }

    public static int longestStreak(Random random, int flips) {
        return 0;
    }
}
