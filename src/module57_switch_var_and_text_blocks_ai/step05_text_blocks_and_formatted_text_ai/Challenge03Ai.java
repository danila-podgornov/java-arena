// AI-Generated
package module57_switch_var_and_text_blocks_ai.step05_text_blocks_and_formatted_text_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A snack bar prints receipts. The program reads lines, each an item, its price and a quantity separated by spaces, such as {@code coffee 2.80 2}, until the line {@code end}. For each item it prints the name left-aligned in 10 characters and the item's total (price times quantity) right-aligned in 8 characters with two decimals. Then it prints a line of 18 minus signs, and {@code TOTAL} with the sum of the totals in the same two columns. With this input:
     * <p>Input
     * <pre>{@code
     * coffee 2.80 2
     * bagel 3.25 1
     * juice 4.10 3
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * coffee        5.60
     * bagel         3.25
     * juice        12.30
     * ------------------
     * TOTAL        21.15
     * }</pre>
     * Hints
     * 1. Split each line with {@code split(" ")}: the name, the price ({@code Double.valueOf}) and the quantity ({@code Integer.valueOf}). Keep a running sum of the totals.
     * 2. {@code String.format("%-10s%8.2f", name, total)} makes one line of the receipt, and the TOTAL line uses the same format.
     */
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

    }
}
