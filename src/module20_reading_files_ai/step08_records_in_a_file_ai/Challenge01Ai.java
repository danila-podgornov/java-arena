// AI-Generated
package module20_reading_files_ai.step08_records_in_a_file_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The file {@code stock.txt} has lines such as {@code pens;40}: an item and how many are left in stock, separated by a semicolon. Fill in the blanks, so the program prints the items that have fewer than 10 left. For the file shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Low on stock:
     * glue (4)
     * tape (0)
     * }</pre>
     * Hints
     * 1. Look at the file: the item and the count are separated by {@code ;}.
     * 2. The count is text until {@code Integer.valueOf(parts[1])} makes it an {@code int}.
     */
    public static void main(String[] args) {
        System.out.println("Low on stock:");
        try (Scanner scanner = new Scanner(Paths.get("stock.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("___");
                int count = Integer.___(parts[1]);
                if (count < 10) {
                    System.out.println(parts[0] + " (" + count + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
