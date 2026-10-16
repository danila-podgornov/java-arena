// AI-Generated
package module20_reading_files_ai.step03_reading_a_file_line_by_line_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so the program prints every line of {@code todo.txt} with its number in front. For the file shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1. buy stamps
     * 2. call the dentist
     * 3. water the plants
     * }</pre>
     * Hints
     * 1. The loop's condition asks whether there's a line left: {@code hasNextLine}.
     * 2. Inside the loop, {@code nextLine} reads the line.
     */
    public static void main(String[] args) {
        int number = 0;
        try (Scanner scanner = new Scanner(Paths.get("todo.txt"))) {
            while (scanner.___()) {
                String task = scanner.___();
                number++;
                System.out.println(number + ". " + task);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
