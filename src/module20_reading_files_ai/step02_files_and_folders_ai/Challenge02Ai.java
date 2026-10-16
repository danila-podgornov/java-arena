// AI-Generated
package module20_reading_files_ai.step02_files_and_folders_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * This program should print every bird in the file {@code birds.txt} after {@code Seen: }, but it prints {@code Error: birds} instead. Fix it. For the file shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Seen: robin
     * Seen: magpie
     * Seen: blue tit
     * }</pre>
     * Hints
     * 1. {@code Error: birds} means the program looked for a file called {@code birds}, and there's no file with exactly that name.
     * 2. The extension is part of the name: {@code Paths.get("birds.txt")}.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("birds"))) {
            while (scanner.hasNextLine()) {
                String bird = scanner.nextLine();
                System.out.println("Seen: " + bird);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
