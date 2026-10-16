// AI-Generated
package module20_reading_files_ai.step09_objects_from_a_file_ai.challenge01_ai;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * The file {@code plants.txt} has lines such as {@code fern,7}: a plant, and how many days go by between waterings. {@code Plant.java} is ready. Complete {@code main}, so it creates a {@code Plant} from each line, adds it to the list {@code plants}, and then prints every plant. For the file shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * fern: water every 7 days
     * cactus: water every 21 days
     * basil: water every 2 days
     * }</pre>
     * Hints
     * 1. In the loop, split the line: {@code String[] parts = scanner.nextLine().split(",");}. Then {@code plants.add(new Plant(parts[0], Integer.valueOf(parts[1])));}.
     * 2. After the {@code try}/{@code catch}, print every plant with a for-each loop. Printing a {@code Plant} prints what its {@code toString} returns.
     */
    public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("plants.txt"))) {
            while (scanner.hasNextLine()) {

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
