// AI-Generated
package module08_repeating_with_while_ai.step01_while_true_and_break_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so the loop keeps reading until the password is {@code open sesame}. For the input {@code abracadabra} and then {@code open sesame} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * The door stays shut.
     * The door opens!
     * }</pre>
     * Hints
     * 1. The loop repeats forever until something stops it, so its condition is always true.
     * 2. The word that leaves a loop is {@code break}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (___) {
            String attempt = scanner.nextLine();
            if (attempt.equals("open sesame")) {
                ___;
            }
            System.out.println("The door stays shut.");
        }
        System.out.println("The door opens!");
    }
}
