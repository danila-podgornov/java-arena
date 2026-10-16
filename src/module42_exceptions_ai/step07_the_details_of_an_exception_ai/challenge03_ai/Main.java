// AI-Generated
package module42_exceptions_ai.step07_the_details_of_an_exception_ai.challenge03_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    /**
     * The closing challenge puts the module together. A home heating system reads its schedule from {@code schedule.txt}. Each line has a time and a temperature, separated by a space, such as {@code 06:30 21}. {@code Heating.java} is ready: {@code add(time, degrees)} adds a change to the schedule, and throws an IllegalArgumentException when the temperature isn't between 5 and 30 degrees; {@code count()} returns how many changes it has.
     * <p>Write {@code main}. Read the file line by line with a Scanner in a try-with-resources, and for each line:
     * <ul>
     * <li>add it to the Heating, and print the time, {@code ->} and the temperature, like {@code 06:30 -> 21}
     * <li>if the temperature isn't a whole number, print {@code Line } and the line's number, then {@code : not a number: } and the temperature, like {@code Line 4: not a number: warm}
     * <li>if {@code add} refuses it, print {@code Line }, the line's number, {@code : } and the exception's message
     * </ul>
     * <p>When the file can't be read, print {@code Could not read schedule.txt}. At the very end, print {@code Changes: } and how many changes the Heating has. Every line of the file has a time, a space and a temperature. For the file shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 06:30 -> 21
     * 08:00 -> 17
     * Line 3: 45 degrees is not a room temperature
     * Line 4: not a number: warm
     * 22:00 -> 18
     * Changes: 3
     * }</pre>
     * Hints
     * 1. The Heating is made before the {@code try}, so it still exists afterwards for the count. Inside {@code try (Scanner scanner = new Scanner(Paths.get("schedule.txt"))) { ... }}, count the lines in a variable as you read them.
     * 2. Give each line a {@code try} of its own: {@code Integer.parseInt(parts[1])}, then {@code heating.add(...)}, then the {@code println}. Catch {@code NumberFormatException} first and {@code IllegalArgumentException} second. The outer {@code try} gets a {@code catch (Exception e)} for the file, and {@code Changes: } is printed after it.
     */
    public static void main(String[] args) {
        Heating heating = new Heating();

    }
}
