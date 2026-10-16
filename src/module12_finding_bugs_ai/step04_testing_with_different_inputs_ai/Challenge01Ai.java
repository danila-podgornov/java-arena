// AI-Generated
package module12_finding_bugs_ai.step04_testing_with_different_inputs_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fix the program above so it works for every input, negative numbers too. It reads how many numbers follow, then the numbers (at least one). With the input {@code 3}, {@code -5}, {@code -2}, {@code -8} it prints: see the expected output below.
     * Expected output
     * {@code Largest: -2}
     * Hints
     * 1. Read the first number before the loop and start {@code largest} from it. The loop then reads the remaining numbers.
     * 2. If the first number is read before the loop, the loop runs one round fewer: start the counter at 1.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        int largest = 0;
        for (int i = 0; i < count; i++) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number > largest) {
                largest = number;
            }
        }
        System.out.println("Largest: " + largest);
    }
}
