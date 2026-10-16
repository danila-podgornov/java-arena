// AI-Generated
package module29_larger_programs_ai.step04_questions_about_a_file_of_records_ai.challenge01_ai;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * A city's charging stations for electric cars are in the file {@code stations.csv}. After a header line, each line has a station's name, how many of its chargers are free, and how many chargers it has in all, like {@code Harbor,3,6}. Some lines are broken: an empty line, or a line with fewer than three values. {@code Station.java} is ready, and so is {@code main}, which asks the questions. In {@code Main.java}, complete {@code readStations}: turn each line into a {@code Station} and add it to the list, and skip every line that splits into fewer than three parts. For the file shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Stations: 4
     * Nothing free at:
     * Market Square
     * Park Gate
     * Free chargers in all: 10
     * Most chargers: Market Square
     * }</pre>
     * Hints
     * 1. Split the line at the commas with {@code line.split(",")}. An empty line splits into one part, the empty text, so the same check skips it too.
     * 2. {@code if (parts.length < 3) { continue; }} skips a broken line. Then {@code stations.add(new Station(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));}.
     */
    public static void main(String[] args) {
        ArrayList<Station> stations = readStations("stations.csv");
        System.out.println("Stations: " + stations.size());
        System.out.println("Nothing free at:");
        int free = 0;
        Station biggest = null;
        for (Station station : stations) {
            if (station.getFree() == 0) {
                System.out.println(station.getName());
            }
            free += station.getFree();
            if (biggest == null || station.getChargers() > biggest.getChargers()) {
                biggest = station;
            }
        }
        System.out.println("Free chargers in all: " + free);
        if (biggest != null) {
            System.out.println("Most chargers: " + biggest.getName());
        }
    }

    public static ArrayList<Station> readStations(String fileName) {
        ArrayList<Station> stations = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Turn the line into a Station, and skip lines of fewer than three parts.
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return stations;
    }
}
