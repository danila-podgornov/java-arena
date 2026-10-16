// AI-Generated
package module12_finding_bugs_ai.step03_print_debugging_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This program should count how many of the numbers typed are even, until the user types {@code -1}. It gives the wrong count. Find the bug (a debug print inside the loop helps), fix it, and make sure no debug prints are left. With the input {@code 4}, {@code 7}, {@code 10}, {@code -1} it prints: see the expected output below.
     * Expected output
     * {@code Even numbers: 2}
     * Hints
     * 1. Print {@code number} and {@code evens} inside the loop, after the {@code if}. Which numbers make {@code evens} go up?
     * 2. An even number leaves no remainder when divided by 2: {@code number % 2 == 0}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int evens = 0;
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break;
            }
            if (number % 2 == 1) {
                evens++;
            }
        }
        System.out.println("Even numbers: " + evens);
    }
}
