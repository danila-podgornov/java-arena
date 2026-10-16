// AI-Generated
package module04_calculating_with_numbers_ai.step03_numbers_and_text_together_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This program should print {@code Total: 12} for the input {@code 5} and {@code 7}, but it prints {@code Total: 57}. Fix it.
     * Input
     * <pre>{@code
     * 5
     * 7
     * }</pre>
     * Hints
     * 1. Going from left to right, {@code "Total: " + a} is already text, so {@code + b} joins instead of adding.
     * 2. Put parentheses around the calculation, so it's done first.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        int b = Integer.valueOf(scanner.nextLine());
        System.out.println("Total: " + a + b);
    }
}
