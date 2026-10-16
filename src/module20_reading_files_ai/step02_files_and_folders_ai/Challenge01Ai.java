// AI-Generated
package module20_reading_files_ai.step02_files_and_folders_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This challenge gives the file {@code recipe.txt}, shown below. Fill in its name, so the program prints each line of the recipe after a dash. For the file shown, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * - 2 eggs
     * - 1 cup of milk
     * - 1 cup of flour
     * }</pre>
     * Hints
     * 1. The task shows the file's name above its contents.
     * 2. The whole name goes between the quotes, extension included: {@code recipe.txt}.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("___"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("- " + line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
