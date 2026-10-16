// AI-Generated
package module05_making_decisions_ai.step03_comparison_operators_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * Read a year and print {@code That's before Unix time began.} when it's earlier than 1970. (Unix time, which many computers use to count time, starts on 1 January 1970.) Always finish with {@code Thanks!} For the input {@code 1969} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Year:
     * That's before Unix time began.
     * Thanks!
     * }</pre>
     * Hints
     * 1. Earlier than 1970 means less than: {@code year < 1970}.
     * 2. A hidden test tries 1970 itself, which is not earlier.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Year:");
        int year = Integer.valueOf(scanner.nextLine());

    }
}
