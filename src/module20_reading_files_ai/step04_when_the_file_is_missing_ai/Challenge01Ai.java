// AI-Generated
package module20_reading_files_ai.step04_when_the_file_is_missing_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks. The program prints the lines of {@code menu.txt}. When the file can't be read, it prints {@code Could not read the file: } and the error's message instead, so without the file it prints {@code Could not read the file: menu.txt} (one of the tests gives no file). For the file shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * tomato soup
     * pasta
     * apple pie
     * }</pre>
     * Hints
     * 1. The block that runs when something goes wrong starts with {@code catch}.
     * 2. The exception's message comes from {@code e.getMessage()}.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("menu.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } ___ (Exception e) {
            System.out.println("Could not read the file: " + e.___());
        }
    }
}
