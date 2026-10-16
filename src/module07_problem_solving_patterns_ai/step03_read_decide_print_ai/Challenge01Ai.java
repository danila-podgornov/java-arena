// AI-Generated
package module07_problem_solving_patterns_ai.step03_read_decide_print_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A weather app reads how many degrees the temperature changed since yesterday, negative when it got colder. Print the size of the change, without a minus sign. Use an {@code if} for it, not {@code Math.abs}, to practice the pattern. For the input {@code -7} the program prints: see the expected output below.
     * Expected output
     * {@code Change of 7 degrees}
     * Hints
     * 1. Only a negative change needs fixing up before it's printed.
     * 2. {@code -change} is the number with its sign flipped: {@code if (change < 0) { change = -change; }}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int change = Integer.valueOf(scanner.nextLine());

    }
}
