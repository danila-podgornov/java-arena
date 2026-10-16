// AI-Generated
package module46_random_numbers_ai.step02_seeds_the_same_numbers_every_time_ai;

import java.util.HashSet;
import java.util.Random;

public class Challenge02Ai {
    /**
     * {@code rollDie} creates a new Random, with a seed, every time it's called. What does this program print? You can't know which numbers come up, but you can know how many different ones.
     * Hints
     * 1. Each call of {@code rollDie} starts a new generator from the seed 2024, and takes its first number. Every call takes the same first number.
     * 2. The second loop keeps one generator and takes 100 numbers from it, one after the other. In 100 rolls, every face of a die comes up.
     */
    public static void main(String[] args) {
        HashSet<Integer> fresh = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            fresh.add(rollDie());
        }
        Random random = new Random(2024);
        HashSet<Integer> shared = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            shared.add(random.nextInt(6) + 1);
        }
        System.out.println(fresh.size() + " " + shared.size());
    }

    public static int rollDie() {
        Random random = new Random(2024);
        return random.nextInt(6) + 1;
    }
}
