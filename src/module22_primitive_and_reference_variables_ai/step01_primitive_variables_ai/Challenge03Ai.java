// AI-Generated
package module22_primitive_and_reference_variables_ai.step01_primitive_variables_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The program reads two whole numbers, the ends of a range, and prints every number from the smaller one up to the larger one. The user may type the ends in either order. The loop is ready, and it counts from {@code low} up to {@code high}: when {@code low} is the larger number, swap the values of {@code low} and {@code high} before the loop, with a third variable as in the example. For the input {@code 6} and {@code 3} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 4
     * 5
     * 6
     * }</pre>
     * Hints
     * 1. Swap only when it's needed: {@code if (low > high) { ... }}.
     * 2. Inside the {@code if}, three lines: {@code int temp = low;}, then {@code low = high;}, then {@code high = temp;}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = Integer.valueOf(scanner.nextLine());
        int high = Integer.valueOf(scanner.nextLine());
        // Swap the values here when low is larger than high.

        for (int i = low; i <= high; i++) {
            System.out.println(i);
        }
    }
}
