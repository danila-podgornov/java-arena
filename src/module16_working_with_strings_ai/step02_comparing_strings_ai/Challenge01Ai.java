// AI-Generated
package module16_working_with_strings_ai.step02_comparing_strings_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A shop's checkout takes one discount code, {@code SPRING10}, and capitals don't matter: {@code spring10} and {@code Spring10} work too. Ask for the code, read it, and print {@code Code accepted} for the right code, otherwise {@code Unknown code}. For the input {@code spring10} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Discount code:
     * Code accepted
     * }</pre>
     * Hints
     * 1. {@code equals} would say no to {@code spring10}, because capitals count. {@code equalsIgnoreCase} doesn't count them.
     * 2. {@code if (code.equalsIgnoreCase("SPRING10")) { ... } else { ... }}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Discount code:");
        String code = scanner.nextLine();

    }
}
