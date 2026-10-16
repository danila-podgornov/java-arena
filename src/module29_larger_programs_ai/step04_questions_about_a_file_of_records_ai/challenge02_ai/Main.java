// AI-Generated
package module29_larger_programs_ai.step04_questions_about_a_file_of_records_ai.challenge02_ai;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * A school sports day saves its results in {@code results.csv}, one per line: the athlete's name, the event and the result in centimeters, like {@code Ada,long jump,412}. {@code Result.java} is ready, and so is {@code readResults}, which reads the file into a list. In {@code main}, read an event's name from the keyboard, and then print:
     * <ul>
     * <li>every result in that event, in the file's order,
     * <li>{@code Results: } and how many results the event has,
     * <li>{@code Best: } and the best result, the one with the most centimeters. If two are equal, the first one.
     * </ul>
     * <p>If the event has no results, print only {@code No results for } and the event's name. For the input {@code long jump} and the file shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ada (412 cm)
     * Cleo (388 cm)
     * Dev (431 cm)
     * Results: 3
     * Best: Dev (431 cm)
     * }</pre>
     * Hints
     * 1. One for-each loop answers all three questions. Skip a result with {@code continue} when {@code !result.getEvent().equals(event)}, and print, count and compare the rest.
     * 2. Keep {@code Result best = null;} before the loop, and replace it when it's {@code null} or when the result has more centimeters ({@code >}, so that the first of two equal ones stays). After the loop, a count of 0 means no results.
     */
    public static void main(String[] args) {
        ArrayList<Result> results = readResults("results.csv");
        Scanner scanner = new Scanner(System.in);
        String event = scanner.nextLine();
        // Answer the questions about the event here.
    }

    public static ArrayList<Result> readResults(String fileName) {
        ArrayList<Result> results = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length < 3) {
                    continue;
                }
                results.add(new Result(parts[0], parts[1], Integer.valueOf(parts[2])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return results;
    }
}
