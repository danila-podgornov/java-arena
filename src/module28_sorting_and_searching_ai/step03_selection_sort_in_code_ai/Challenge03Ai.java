// AI-Generated
package module28_sorting_and_searching_ai.step03_selection_sort_in_code_ai;

import java.util.Arrays;

public class Challenge03Ai {
    /**
     * The board-game club from step 1 wants its scores from the highest down. Write the method {@code sortHighFirst(int[] scores)}, which sorts the array it's given from the highest score to the lowest with selection sort: each round finds the highest score from the round's index on, and swaps it there. Write it as one method or with helper methods, as you like (step 1's {@code highestFrom} would fit right in). The check runs:
     * <pre>{@code
     * int[] scores = {42, 57, 38, 57, 49};
     * sortHighFirst(scores);
     * System.out.println(Arrays.toString(scores));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [57, 57, 49, 42, 38]}
     * Hints
     * 1. It's the selection sort of this step with one change: each round looks for the *highest* score from index {@code i} on, so the comparison is {@code scores[j] > scores[highest]}.
     * 2. After the inner loop, swap the scores at {@code i} and at {@code highest}, with a {@code temp} variable. The outer loop runs {@code for (int i = 0; i < scores.length - 1; i++)}.
     */
    public static void main(String[] args) {
        int[] scores = {42, 57, 38, 57, 49};
        sortHighFirst(scores);
        System.out.println(Arrays.toString(scores));
    }

    // Write the method sortHighFirst here.
}
