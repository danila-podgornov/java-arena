// AI-Generated
package module13_lists_ai.step07_sums_averages_and_the_largest_value_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A high jumper's coach wants to know how steady the jumper is. Read the heights of the jumps in centimeters, one per line, until {@code 0}, and keep them in a list. Then print the best (highest) jump, and how many jumps came within 5 centimeters of it: at most 5 below the best, the best one included. There's always at least one jump. For the input {@code 175}, {@code 182}, {@code 150}, {@code 178} and {@code 0} the program prints:
     * <pre>{@code
     * Best: 182
     * Close to best: 2
     * }</pre>
     * <p>Here 182 and 178 count, while 175 is 7 centimeters short.
     * Hints
     * 1. Two loops over the list: the first finds the best jump, starting from {@code jumps.get(0)}. Only once it's known can the second loop compare every jump with it.
     * 2. In the second loop, a jump counts when {@code best - jumps.get(i) <= 5}. Start the counter at 0 before that loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> jumps = new ArrayList<>();

    }
}
