// AI-Generated
package module46_random_numbers_ai.step01_random_and_nextint_ai;

import java.util.Random;

public class Challenge02Ai {
    /**
     * A board game moves your piece by the total of two dice. Write the method {@code rollTwoDice(Random random)}, which rolls two six-sided dice with the Random it's given and returns their total. Roll each die with a {@code nextInt} call of its own: as the lesson showed, {@code nextInt(11) + 2} gives the right range but the wrong chances.
     * <p>The check rolls 18000 times. It prints whether every total was from 2 to 12, and whether a 7 came up at least three times as often as a 2, which is true for real dice: see the expected output below.
     * Expected output
     * <pre>{@code
     * every total from 2 to 12: true
     * 7 at least 3 times as often as 2: true
     * }</pre>
     * Hints
     * 1. Roll one die from 1 to 6 the way the lesson did, then roll a second one, and add them up. Use the Random from the parameter: no {@code new Random()} in the method.
     * 2. {@code int first = random.nextInt(6) + 1;}, the same for {@code second}, then {@code return first + second;}.
     */
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("You rolled " + rollTwoDice(random));
    }

    public static int rollTwoDice(Random random) {
        return 0;
    }
}
