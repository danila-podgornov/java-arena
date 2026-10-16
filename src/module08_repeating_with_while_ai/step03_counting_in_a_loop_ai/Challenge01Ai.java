// AI-Generated
package module08_repeating_with_while_ai.step03_counting_in_a_loop_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This program should count the words before {@code end}, but it always prints {@code Words: 0}. Move the counter so it works. For the input {@code red}, {@code green}, {@code blue} and {@code end} the program prints: see the expected output below.
     * Expected output
     * {@code Words: 3}
     * Hints
     * 1. {@code int count = 0;} runs every time the loop comes round, so the counter keeps going back to 0.
     * 2. Move {@code int count = 0;} above the {@code while} line.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int count = 0;
            String word = scanner.nextLine();
            if (word.equals("end")) {
                System.out.println("Words: " + count);
                break;
            }
            count++;
        }
    }
}
