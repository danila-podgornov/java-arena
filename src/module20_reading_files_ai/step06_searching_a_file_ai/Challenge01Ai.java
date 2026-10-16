// AI-Generated
package module20_reading_files_ai.step06_searching_a_file_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The file {@code reviews.txt} holds a restaurant's reviews, one per line. The program reads a word and counts the reviews that mention it. Fill in the blanks. For the input {@code pizza} and the file shown below, it prints: see the expected output below.
     * Expected output
     * {@code Reviews that mention pizza: 3}
     * Hints
     * 1. A review mentions the word when the word is somewhere inside the line: {@code contains}.
     * 2. The second blank adds one to the counter: {@code count++}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int count = 0;
        try (Scanner fileScanner = new Scanner(Paths.get("reviews.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.___(word)) {
                    ___;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Reviews that mention " + word + ": " + count);
    }
}
