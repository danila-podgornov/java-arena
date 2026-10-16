// AI-Generated
package module15_arrays_ai.step03_arrays_of_other_types_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks. The program reads how many prices follow, then the prices, and prints their total. For the input {@code 3}, {@code 2.5}, {@code 4.0} and {@code 1.25} it prints: see the expected output below.
     * Expected output
     * {@code Total: 7.75}
     * Hints
     * 1. The array holds decimal numbers, so its type is an array of {@code double}.
     * 2. The for-each variable has the element type too: both blanks are {@code double}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        ___[] prices = new double[count];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Double.valueOf(scanner.nextLine());
        }
        double total = 0;
        for (___ price : prices) {
            total += price;
        }
        System.out.println("Total: " + total);
    }
}
