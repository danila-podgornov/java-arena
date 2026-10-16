// AI-Generated
package module16_working_with_strings_ai.step05_splitting_a_string_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so the program counts the words in a line. For the input {@code I like green tea} it prints: see the expected output below.
     * Expected output
     * {@code Words: 4}
     * Hints
     * 1. {@code split} cuts the line at every space and returns the pieces as an array.
     * 2. The size of an array is {@code length}, without parentheses.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.___(" ");
        System.out.println("Words: " + words.___);
    }
}
