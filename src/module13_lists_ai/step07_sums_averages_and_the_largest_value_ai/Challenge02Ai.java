// AI-Generated
package module13_lists_ai.step07_sums_averages_and_the_largest_value_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * Fill in the blanks so the program adds up the ratings and prints their average: see the expected output below.
     * Expected output
     * {@code Average rating: 3.8}
     * Hints
     * 1. The loop runs over every index, as long as {@code i < ratings.size()}.
     * 2. Each round adds this round's rating to the sum: {@code sum += ratings.get(i)}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ratings = new ArrayList<>();
        ratings.add(4);
        ratings.add(5);
        ratings.add(3);
        ratings.add(2);
        ratings.add(5);
        int sum = 0;
        for (int i = 0; i < ___; i++) {
            sum ___;
        }
        System.out.println("Average rating: " + (double) sum / ratings.size());
    }
}
