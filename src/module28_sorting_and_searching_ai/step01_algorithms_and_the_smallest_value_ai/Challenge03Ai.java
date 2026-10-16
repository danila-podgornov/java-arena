// AI-Generated
package module28_sorting_and_searching_ai.step01_algorithms_and_the_smallest_value_ai;

public class Challenge03Ai {
    /**
     * A board-game club keeps the winning score of each game night in an array. Write the method {@code highestFrom(int[] scores, int start)}. It returns the index of the highest score from index {@code start} on. When two scores are equally high, it returns the index of the first one. The check runs:
     * <pre>{@code
     * int[] scores = {42, 57, 38, 57, 49};
     * System.out.println(highestFrom(scores, 0));
     * System.out.println(highestFrom(scores, 2));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1
     * 3
     * }</pre>
     * Hints
     * 1. The method starts <code>public static int highestFrom(int[] scores, int start) {</code>. Keep the index of the highest score so far, starting from {@code start}.
     * 2. Compare with {@code >}, not {@code >=}: then a later score that only ties doesn't take the place of the first one.
     */
    public static void main(String[] args) {
        int[] scores = {42, 57, 38, 57, 49};
        System.out.println(highestFrom(scores, 0));
        System.out.println(highestFrom(scores, 2));
    }

    // Write the method highestFrom here.
}
