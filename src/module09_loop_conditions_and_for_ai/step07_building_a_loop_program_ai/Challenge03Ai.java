// AI-Generated
package module09_loop_conditions_and_for_ai.step07_building_a_loop_program_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Stage 3. Also print how many days reached the goal of 10000 steps, and the best day. For the input {@code 8000}, {@code 12000}, {@code 5000} and {@code -1} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Days: 3
     * Total: 25000
     * Average: 8333.333333333334
     * Days at 10000 or more: 1
     * Best day: 12000
     * }</pre>
     * Hints
     * 1. Two more variables before the loop: a counter for goal days and {@code int best = 0;}.
     * 2. In the loop: {@code if (steps >= 10000) { goalDays++; }} and {@code if (steps > best) { best = steps; }}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int days = 0;
        while (true) {
            int steps = Integer.valueOf(scanner.nextLine());
            if (steps == -1) {
                break;
            }
            total += steps;
            days++;
        }
        System.out.println("Days: " + days);
        System.out.println("Total: " + total);
        System.out.println("Average: " + (double) total / days);
    }
}
