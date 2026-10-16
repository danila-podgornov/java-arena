// AI-Generated
package module57_switch_var_and_text_blocks_ai.step03_switch_on_strings_and_enums_ai.challenge02_ai;

public class Main {
    /**
     * A car wash charges by the program. {@code Wash.java} has the enum {@code Wash}, with the constants {@code BASIC}, {@code FOAM} and {@code DELUXE}. In {@code Main.java}, write the method {@code washPrice(Wash wash)}, which returns the price in euros with a switch expression: 4 for BASIC, 7 for FOAM and 12 for DELUXE. Cover every constant, and leave out {@code default}. The check runs {@code System.out.println(washPrice(Wash.FOAM));}, which prints: see the expected output below.
     * Expected output
     * {@code 7}
     * Hints
     * 1. The labels are the constants' names alone: {@code case BASIC -> 4;}.
     * 2. {@code return switch (wash) { ... };} with a case for each of the three constants compiles without a {@code default}, since nothing else is left.
     */
    public static void main(String[] args) {
        System.out.println(washPrice(Wash.FOAM));
    }

    public static int washPrice(Wash wash) {
        return 0;
    }
}
