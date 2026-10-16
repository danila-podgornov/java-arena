// AI-Generated
package module15_arrays_ai.step06_the_short_way_to_create_an_array_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Read die rolls, one per line, until {@code 0}. Each roll is a whole number from 1 to 6, and there's at least one. Count how many times each face came up, using an int array as the counters. Then print each face with its count, from 1 to 6, and last the face that came up most often. If several faces tie, print the smallest of them. For the input {@code 4}, {@code 2}, {@code 6}, {@code 4}, {@code 1}, {@code 4}, {@code 2} and {@code 0} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Face 1: 1
     * Face 2: 2
     * Face 3: 0
     * Face 4: 3
     * Face 5: 0
     * Face 6: 1
     * Most common: 4
     * }</pre>
     * Hints
     * 1. {@code int[] counts = new int[7];} has the indexes 0 to 6, so each face can use its own number: {@code counts[roll]++;}
     * 2. Finding the most common face is the largest-value search from this module, over the indexes 1 to 6. Start from face 1, and switch only on a count that's {@code >} the best so far, so the smallest face wins a tie.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
