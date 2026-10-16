// AI-Generated
package module20_reading_files_ai.step07_files_of_numbers_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The file {@code calls.txt} holds the length of each phone call in minutes. Fill in the blanks, so the program prints the total and the average length. For the file shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Total: 57 minutes
     * Average: 14.25 minutes
     * }</pre>
     * Hints
     * 1. A line becomes an {@code int} with {@code Integer.valueOf(line)}.
     * 2. The average is the total divided by the number of calls, {@code calls}.
     */
    public static void main(String[] args) {
        int total = 0;
        int calls = 0;
        try (Scanner scanner = new Scanner(Paths.get("calls.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int minutes = Integer.___(line);
                total += minutes;
                calls++;
            }
            System.out.println("Total: " + total + " minutes");
            System.out.println("Average: " + ((double) total / ___) + " minutes");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
