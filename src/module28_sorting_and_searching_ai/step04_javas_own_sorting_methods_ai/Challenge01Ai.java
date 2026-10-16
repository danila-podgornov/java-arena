// AI-Generated
package module28_sorting_and_searching_ai.step04_javas_own_sorting_methods_ai;

import java.util.Arrays;

public class Challenge01Ai {
    /**
     * A museum counts its visitors every day. Fill in the blanks of {@code printRange}, which sorts the array of daily counts, prints it, and then prints the fewest and the most visitors in a day. After sorting, where in the array are those two? The check runs:
     * <pre>{@code
     * int[] visitors = {230, 41, 118, 96, 187};
     * printRange(visitors);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [41, 96, 118, 187, 230]
     * Fewest: 41, most: 230
     * }</pre>
     * Hints
     * 1. {@code Arrays.sort(visitors)} sorts the array in place, from the smallest count to the largest.
     * 2. After sorting, the fewest visitors are at the first index, 0, and the most at the last one, {@code visitors.length - 1}.
     */
    public static void main(String[] args) {
        int[] visitors = {230, 41, 118, 96, 187};
        printRange(visitors);
    }

    public static void printRange(int[] visitors) {
        Arrays.___(visitors);
        System.out.println(Arrays.toString(visitors));
        System.out.println("Fewest: " + visitors[___] + ", most: " + visitors[___]);
    }
}
