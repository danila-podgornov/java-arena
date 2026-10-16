// AI-Generated
package module12_finding_bugs_ai.step01_reading_a_crash_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This program reads scores until the user types {@code 0}, then prints their average. It crashes when the very first input is {@code 0}. Make it print {@code No scores} in that case, and the average otherwise. With the input {@code 0} it prints: see the expected output below.
     * Expected output
     * {@code No scores}
     * Hints
     * 1. Run it with the input {@code 0} and read the crash: which line, and which value is zero there?
     * 2. {@code count} is 0 when no score was added. Check {@code if (count == 0)} before dividing, and print {@code No scores} then.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int count = 0;
        while (true) {
            int score = Integer.valueOf(scanner.nextLine());
            if (score == 0) {
                break;
            }
            total += score;
            count++;
        }
        System.out.println("Average: " + (total / count));
    }
}
