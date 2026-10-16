// AI-Generated
package module46_random_numbers_ai.step03_decimal_numbers_and_chances_ai;

import java.util.Random;

public class Challenge01Ai {
    /**
     * A board game has bonus squares: landing on one gives you a bonus 25% of the time. Fill in the blanks so that {@code bonus} returns {@code true} with that chance, using {@code nextDouble}. {@code main} lands on 10000 bonus squares, with a seeded Random, and prints how many gave a bonus: see the expected output below.
     * Expected output
     * {@code Bonus on 2506 of 10000 squares}
     * Hints
     * 1. The method that gives a decimal number from 0.0 up to 1.0 is {@code nextDouble}.
     * 2. 25% of the numbers from 0.0 to 1.0 are below 0.25.
     */
    public static void main(String[] args) {
        Random random = new Random(23);
        int bonuses = 0;
        for (int i = 0; i < 10000; i++) {
            if (bonus(random)) {
                bonuses++;
            }
        }
        System.out.println("Bonus on " + bonuses + " of 10000 squares");
    }

    public static boolean bonus(Random random) {
        return random.___() < ___;
    }
}
