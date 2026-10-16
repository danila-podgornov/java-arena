// AI-Generated
package module09_loop_conditions_and_for_ai.step07_building_a_loop_program_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * Stage 2. Also count the days and print the average steps per day. There's always at least one day. For the input {@code 8000}, {@code 12000}, {@code 5000} and {@code -1} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Days: 3
     * Total: 25000
     * Average: 8333.333333333334
     * }</pre>
     * Hints
     * 1. Add a {@code days} counter next to {@code total}, and {@code days++;} in the loop.
     * 2. The average after the loop: {@code (double) total / days}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        while (true) {
            int steps = Integer.valueOf(scanner.nextLine());
            if (steps == -1) {
                break;
            }
            total += steps;
        }
        System.out.println("Total: " + total);
    }
}
