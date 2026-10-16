// AI-Generated
package module46_random_numbers_ai.step04_picking_shuffling_and_drawing_ai;

import java.util.ArrayList;
import java.util.Random;

public class Challenge01Ai {
    /**
     * A trivia night picks a random category for each round. Fill in the blanks so that {@code pickCategory} returns a random category from the list, each as likely as the others. {@code main} picks for three rounds with a seeded Random: see the expected output below.
     * Expected output
     * <pre>{@code
     * Round 1: science
     * Round 2: sports
     * Round 3: history
     * }</pre>
     * Hints
     * 1. A random index of a list is a whole number from 0 to the list's size - 1: {@code nextInt} with the size as its bound.
     * 2. The list's size is {@code categories.size()}, so the index is {@code random.nextInt(categories.size())}.
     */
    public static void main(String[] args) {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("history");
        categories.add("science");
        categories.add("music");
        categories.add("sports");
        categories.add("movies");
        Random random = new Random(30);
        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round + ": " + pickCategory(categories, random));
        }
    }

    public static String pickCategory(ArrayList<String> categories, Random random) {
        return categories.get(random.___(categories.___));
    }
}
