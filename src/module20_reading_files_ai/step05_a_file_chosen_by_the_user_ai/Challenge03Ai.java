// AI-Generated
package module20_reading_files_ai.step05_a_file_chosen_by_the_user_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Write a method {@code countLines(String fileName)} that returns how many lines the file has, or {@code -1} if the file can't be read. The check runs {@code System.out.println(countLines("draft.txt"));} with the file shown below, and expects: see the expected output below.
     * Expected output
     * {@code 4}
     * Hints
     * 1. The method opens {@code Paths.get(fileName)}, the name it was given, and counts in a {@code hasNextLine()} loop. Call {@code scanner.nextLine();} in every round to move on to the next line.
     * 2. {@code return -1;} in the {@code catch} block, and {@code return count;} after the whole {@code try}/{@code catch}.
     */
    public static void main(String[] args) {
        System.out.println(countLines("draft.txt"));
    }

    // Write the countLines method here.
}
