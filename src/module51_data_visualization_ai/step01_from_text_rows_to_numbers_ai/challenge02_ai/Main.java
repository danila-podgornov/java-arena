// AI-Generated
package module51_data_visualization_ai.step01_from_text_rows_to_numbers_ai.challenge02_ai;

import java.util.Map;

public class Main {
    /**
     * A running club logs how far its training group ran each week, in kilometers, in {@code weeks.csv}. A week without a training run has a {@code -}:
     * <pre>{@code
     * week,km
     * 1,24.5
     * 2,-
     * 3,31
     * 4,28.5
     * }</pre>
     * <p>Write the class {@code DistanceLog} in {@code DistanceLog.java}, with the method {@code public static Map<Integer, Double> read(String fileName) throws IOException}. It reads the file (the header first, then one row per week) and returns a map from each week's number to its kilometers, as a double. A week with a {@code -} isn't in the map at all.
     * <p>{@code Main.java} is a test drive. The check runs:
     * <pre>{@code
     * Map<Integer, Double> km = DistanceLog.read("weeks.csv");
     * System.out.println(km.size());
     * System.out.println(km.get(1));
     * System.out.println(km.get(3));
     * System.out.println(km.containsKey(2));
     * }</pre>
     * <p>and expects, for the file above: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 24.5
     * 31.0
     * false
     * }</pre>
     * Hints
     * 1. Read the lines with {@code Files.readAllLines(Paths.get(fileName))} and go through them from index 1, which skips the header. Split each row with {@code split(",")}.
     * 2. When {@code parts[1]} isn't {@code "-"}, put {@code Integer.valueOf(parts[0])} and {@code Double.valueOf(parts[1])} into the map. {@code Double.valueOf("31")} is fine too: it gives 31.0.
     */
    public static void main(String[] args) throws Exception {
        Map<Integer, Double> km = DistanceLog.read("weeks.csv");
        System.out.println(km.size());
        System.out.println(km.get(1));
        System.out.println(km.get(3));
        System.out.println(km.containsKey(2));
    }
}
