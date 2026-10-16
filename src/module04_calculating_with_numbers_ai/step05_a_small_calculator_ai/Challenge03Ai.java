// AI-Generated
package module04_calculating_with_numbers_ai.step05_a_small_calculator_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Add one more line: the first number as a percentage of the second, as a decimal number. For the input {@code 5} and {@code 20} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 5 + 20 = 25
     * 5 - 20 = -15
     * 5 * 20 = 100
     * 5 / 20 = 0.25
     * 5 is 25.0% of 20
     * }</pre>
     * Hints
     * 1. A percentage is 100 times the quotient: {@code 100.0 * a / b}.
     * 2. Starting with {@code 100.0} makes the whole calculation a {@code double}, so the decimal part stays.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        int b = Integer.valueOf(scanner.nextLine());
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + ((double) a / b));
    }
}
