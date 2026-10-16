// AI-Generated
package module15_arrays_ai.step02_length_and_loops_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * This program should read a count, fill an array with that many odd numbers (1, 3, 5 and so on), and print them from the last to the first. It crashes. Fix both loops. For the input {@code 4} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 7
     * 5
     * 3
     * 1
     * }</pre>
     * Hints
     * 1. The first loop reaches index {@code odd.length}, one past the last index. It should stop before it: {@code i < odd.length}.
     * 2. The last index is {@code odd.length - 1}, and the first is 0, so the second loop goes from {@code odd.length - 1} down to {@code i >= 0}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        int[] odd = new int[count];
        for (int i = 0; i <= odd.length; i++) {
            odd[i] = 2 * i + 1;
        }
        for (int i = odd.length; i > 0; i--) {
            System.out.println(odd[i]);
        }
    }
}
