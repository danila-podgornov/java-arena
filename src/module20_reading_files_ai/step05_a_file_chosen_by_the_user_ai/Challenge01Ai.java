// AI-Generated
package module20_reading_files_ai.step05_a_file_chosen_by_the_user_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The program reads a file name and prints how many lines that file has. Fill in the blanks. For the input {@code monday.txt} and the files shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Which file?
     * monday.txt: 3 lines
     * }</pre>
     * Hints
     * 1. The file to open is the one the user named: the variable {@code fileName}, without quotes.
     * 2. The loop asks the file's Scanner, {@code fileScanner}, whether it has lines left.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which file?");
        String fileName = scanner.nextLine();
        int lines = 0;
        try (Scanner fileScanner = new Scanner(Paths.get(___))) {
            while (___.hasNextLine()) {
                fileScanner.nextLine();
                lines++;
            }
            System.out.println(fileName + ": " + lines + " lines");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
