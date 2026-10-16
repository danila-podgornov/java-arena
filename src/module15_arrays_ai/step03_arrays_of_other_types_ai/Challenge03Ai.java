// AI-Generated
package module15_arrays_ai.step03_arrays_of_other_types_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The program reads a count and that many whole numbers into an array, and prints the array with a for-each loop. Add code in between that <b>reverses</b> the array: swap the first element with the last, the second with the second to last, and so on. For the input {@code 5}, {@code 1}, {@code 2}, {@code 3}, {@code 4} and {@code 5} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 5
     * 4
     * 3
     * 2
     * 1
     * }</pre>
     * Hints
     * 1. Index {@code i} swaps with index {@code values.length - 1 - i}. Swap with a temporary variable, as in the podium example.
     * 2. Go only halfway: {@code i < values.length / 2}. A loop over the whole array swaps every pair twice, which puts them all back.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        int[] values = new int[count];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.valueOf(scanner.nextLine());
        }

        // Reverse the array here.

        for (int value : values) {
            System.out.println(value);
        }
    }
}
