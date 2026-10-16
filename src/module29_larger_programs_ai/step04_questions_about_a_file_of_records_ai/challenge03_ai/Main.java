// AI-Generated
package module29_larger_programs_ai.step04_questions_about_a_file_of_records_ai.challenge03_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    /**
     * A weather log has one day per line in {@code weather.csv}: the date, the rain in millimeters and the day's highest temperature, like {@code May 1,0,17}. {@code Day.java} and {@code Main.java} are ready: {@code main} reads the file into a {@code WeatherLog} and asks it three questions. In {@code WeatherLog.java}, replace the placeholders:
     * <ul>
     * <li>{@code add(Day day)} adds the day to the list.
     * <li>{@code rainyDays()} returns how many days had some rain (more than 0 mm).
     * <li>{@code totalRain()} returns the rain of all the days added up.
     * <li>{@code warmestDryDay()} returns the day with the highest temperature among the days with no rain, or {@code null} when there's no dry day. If two are equally warm, the first one.
     * </ul>
     * <p>WeatherLog doesn't print anything. For the file shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Rainy days: 3
     * Rain in all: 21 mm
     * Warmest dry day: May 4 (19 degrees, 0 mm)
     * }</pre>
     * Hints
     * 1. {@code rainyDays} is a count with a condition, {@code day.getRain() > 0}, and {@code totalRain} adds up {@code day.getRain()} for every day.
     * 2. {@code warmestDryDay} is a best match, like {@code cheapestFor} in the lesson: skip the rainy days with {@code continue}, and keep the warmest of the rest, starting from {@code null}. Use {@code >}, so that the first of two equally warm days stays.
     */
    public static void main(String[] args) {
        WeatherLog log = new WeatherLog();
        try (Scanner scanner = new Scanner(Paths.get("weather.csv"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length < 3) {
                    continue;
                }
                log.add(new Day(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Rainy days: " + log.rainyDays());
        System.out.println("Rain in all: " + log.totalRain() + " mm");
        Day warmest = log.warmestDryDay();
        if (warmest == null) {
            System.out.println("No dry days");
        } else {
            System.out.println("Warmest dry day: " + warmest);
        }
    }
}
