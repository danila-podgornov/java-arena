// AI-Generated
package module20_reading_files_ai.step05_a_file_chosen_by_the_user_ai;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * Read a file name and then a line number. Print that line of the file: line 1 is the first one. If the file has fewer lines than that, print {@code The file has only } and its number of lines, followed by {@code  lines}. The program prints no questions. For the input {@code poem.txt} and {@code 2} and the files shown below, it prints: see the expected output below.
     * Expected output
     * {@code the cat pretends to sleep}
     * Hints
     * 1. Read the file's lines into a list, with a Scanner of its own: {@code new Scanner(Paths.get(fileName))}.
     * 2. Line 1 is at index 0, so line {@code number} is {@code lines.get(number - 1)}. Check {@code number <= lines.size()} first.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        int number = Integer.valueOf(scanner.nextLine());

    }
}
