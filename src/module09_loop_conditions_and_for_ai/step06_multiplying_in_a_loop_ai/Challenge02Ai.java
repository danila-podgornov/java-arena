// AI-Generated
package module09_loop_conditions_and_for_ai.step06_multiplying_in_a_loop_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * In how many different orders can {@code n} books stand on a shelf? The first place can hold any of the {@code n} books, the next any of the {@code n - 1} left, and so on, so the answer is n times (n - 1) times ... times 1. With 0 books there's exactly 1 way (an empty shelf). Read {@code n} and print the answer. For the input {@code 5} the program prints: see the expected output below.
     * Expected output
     * {@code 5 books can be arranged in 120 ways}
     * Hints
     * 1. Multiply the numbers from 1 to {@code books} together, starting from 1.
     * 2. With 0 books the loop doesn't run, and {@code ways} stays 1, as it should.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int books = Integer.valueOf(scanner.nextLine());

    }
}
