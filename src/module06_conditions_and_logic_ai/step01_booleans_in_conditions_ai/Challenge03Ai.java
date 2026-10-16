// AI-Generated
package module06_conditions_and_logic_ai.step01_booleans_in_conditions_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Read a temperature (an {@code int}) and whether it's raining ({@code true} or {@code false}). Store {@code temperature > 20} in a boolean called {@code warm}. Then print {@code Wear a T-shirt} when it's warm and {@code Wear a sweater} otherwise, and add {@code Take an umbrella} when it's raining. For the input {@code 24} and {@code true} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Wear a T-shirt
     * Take an umbrella
     * }</pre>
     * Hints
     * 1. {@code boolean warm = temperature > 20;} stores the comparison.
     * 2. Two separate decisions: {@code if (warm) ... else ...}, then {@code if (raining) ...}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temperature = Integer.valueOf(scanner.nextLine());
        boolean raining = Boolean.valueOf(scanner.nextLine());

    }
}
