// AI-Generated
package module13_lists_ai.step08_searching_a_list_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Time to put the module together. Read a runner's lap times in whole seconds, one per line, until {@code 0}. There's at least one lap. Then print:
     * <ul>
     * <li>{@code Laps: } and the number of laps,
     * <li>{@code Average: } and the average lap time, as a decimal number,
     * <li>{@code Fastest: lap } and the number of the fastest lap, counting from 1 (on a tie, the earlier lap),
     * <li>{@code Slower than average:}, and after it {@code lap } and the number of every lap whose time is above the average, one per line.
     * </ul>
     * <p>For the input {@code 64}, {@code 61}, {@code 58}, {@code 60}, {@code 63} and {@code 0} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Laps: 5
     * Average: 61.2
     * Fastest: lap 3
     * Slower than average:
     * lap 1
     * lap 5
     * }</pre>
     * Hints
     * 1. Work in parts, after reading the list: a loop for the sum (then the average with {@code (double) total / laps.size()}), a loop for the index of the fastest lap, and a loop that prints the slow laps.
     * 2. The fastest lap is the smallest time: keep its index, and compare with {@code laps.get(i) < laps.get(fastest)}. A lap is slow when {@code laps.get(i) > average}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> laps = new ArrayList<>();

    }
}
