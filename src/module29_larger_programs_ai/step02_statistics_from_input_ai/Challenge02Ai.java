// AI-Generated
package module29_larger_programs_ai.step02_statistics_from_input_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * At a fishing competition, the length of each fish caught is typed in, in whole centimeters, one per line. A {@code 0} ends the input. The rule: a fish shorter than 25 cm is released back into the water, so it doesn't count in the average or the longest, but it's counted as caught and as released. Print:
     * <ul>
     * <li>{@code Fish caught: } and the number of fish caught, kept and released together.
     * <li>If at least one fish was caught: {@code Released: }, the share of released fish as a percentage, calculated as {@code 100.0 * released / caught}, and {@code %}.
     * <li>If at least one fish was kept: {@code Average length: }, the average length of the kept fish (calculated with {@code (double)}) and {@code  cm}, and then {@code Longest: }, the longest fish's length and {@code  cm}.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Fish caught: 5
     * Released: 40.0%
     * Average length: 41.0 cm
     * Longest: 52 cm
     * }</pre>
     * Hints
     * 1. Keep five counts before the loop: caught, released, kept, the total length of the kept fish, and the longest. Check for {@code 0} right after reading, before anything is counted.
     * 2. Every fish adds one to {@code caught}. A fish under 25 cm then adds one to {@code released}, and {@code continue} skips the rest. Check {@code caught > 0} and {@code kept > 0} before dividing by them.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
