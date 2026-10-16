// AI-Generated
package module20_reading_files_ai.step01_reading_until_the_input_ends_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The program reads a letter until its input ends, and prints how many lines it has and how many of them are empty (the gaps between paragraphs). Fill in the blanks. For the input shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lines: 5
     * Empty lines: 2
     * }</pre>
     * Hints
     * 1. The loop runs while there's another line to read: {@code hasNextLine}.
     * 2. The second blank checks whether the line is empty: {@code line.isEmpty()}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = 0;
        int empty = 0;
        while (scanner.___()) {
            String line = scanner.nextLine();
            lines++;
            if (___) {
                empty++;
            }
        }
        System.out.println("Lines: " + lines);
        System.out.println("Empty lines: " + empty);
    }
}
