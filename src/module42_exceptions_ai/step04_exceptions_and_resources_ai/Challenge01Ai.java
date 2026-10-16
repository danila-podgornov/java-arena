// AI-Generated
package module42_exceptions_ai.step04_exceptions_and_resources_ai;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This program reads water meter readings from {@code meter.txt}, one whole number per line, and prints how much water was used: the last reading minus the first. It works, but it never closes the file. Make the Scanner a resource of the {@code try}, so that the file is closed when the reading ends. For the file shown below, it prints: see the expected output below.
     * Expected output
     * {@code Used: 37 liters}
     * Hints
     * 1. Module 20, and the {@code findLine} example above, create the Scanner in the parentheses right after {@code try}. Do the same with this Scanner.
     * 2. Move the Scanner line into {@code try (...)}, without its semicolon: <code>try (Scanner scanner = new Scanner(Paths.get("meter.txt"))) {</code>. The loop stays inside the {@code try} block, and the {@code catch} block stays as it is.
     */
    public static void main(String[] args) {
        ArrayList<Integer> readings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get("meter.txt"));
            while (scanner.hasNextLine()) {
                readings.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        int used = readings.get(readings.size() - 1) - readings.get(0);
        System.out.println("Used: " + used + " liters");
    }
}
