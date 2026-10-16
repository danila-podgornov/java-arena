// AI-Generated
package module05_making_decisions_ai.step06_the_first_true_branch_wins_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * Read a score from 0 to 100 and print its band: 90 to 100 is {@code A}, 70 to 89 is {@code B}, 50 to 69 is {@code C}, and below 50 is {@code D}. For the input {@code 75} the program prints: see the expected output below.
     * Expected output
     * {@code B}
     * Hints
     * 1. Start with the highest band, so each later branch only sees lower scores.
     * 2. {@code if (score >= 90)}, then {@code else if (score >= 70)}, then {@code else if (score >= 50)}, then {@code else}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = Integer.valueOf(scanner.nextLine());

    }
}
