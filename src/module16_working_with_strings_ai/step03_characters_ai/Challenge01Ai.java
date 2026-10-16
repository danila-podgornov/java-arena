// AI-Generated
package module16_working_with_strings_ai.step03_characters_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so the program counts the question marks in a line. For the input {@code Who? What? Why?} it prints: see the expected output below.
     * Expected output
     * {@code Questions: 3}
     * Hints
     * 1. The loop runs as long as {@code i} is less than the number of characters in {@code text}.
     * 2. The character at index {@code i} is {@code text.charAt(i)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < text.___(); i++) {
            if (text.___(i) == '?') {
                count++;
            }
        }
        System.out.println("Questions: " + count);
    }
}
