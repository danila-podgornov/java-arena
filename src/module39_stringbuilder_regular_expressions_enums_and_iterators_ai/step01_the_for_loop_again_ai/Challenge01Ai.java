// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step01_the_for_loop_again_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * In {@code Main.java}, write the method {@code biggestGrowth(ArrayList<Integer> heights)} with a {@code for} loop over the indexes. It returns the sunflower's biggest growth from one week to the next: the largest {@code heights.get(i) - heights.get(i - 1)}. If the sunflower never grew, or the list has fewer than two heights, the method returns 0. The check runs:
     * <pre>{@code
     * ArrayList<Integer> heights = new ArrayList<>();
     * heights.add(12);
     * heights.add(19);
     * heights.add(31);
     * heights.add(30);
     * heights.add(45);
     * System.out.println(biggestGrowth(heights));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 15}
     * Hints
     * 1. Keep the biggest growth so far in a variable that starts at 0. Then a week in which the plant shrank never replaces it, and a list of one height, or none, gives 0.
     * 2. Loop with {@code for (int i = 1; i < heights.size(); i++)}, work out {@code heights.get(i) - heights.get(i - 1)}, and keep it when it's bigger than the biggest so far.
     */
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(12);
        heights.add(19);
        heights.add(31);
        heights.add(30);
        heights.add(45);
        System.out.println(biggestGrowth(heights));
    }

    public static int biggestGrowth(ArrayList<Integer> heights) {
        return 0;
    }
}
