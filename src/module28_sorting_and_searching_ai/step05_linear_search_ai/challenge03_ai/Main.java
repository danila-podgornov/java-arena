// AI-Generated
package module28_sorting_and_searching_ai.step05_linear_search_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * {@code Departure.java} is ready: a bus departure has a line, such as {@code "14"}, and a time, such as {@code "08:05"}, with the getters {@code getLine()} and {@code getTime()}. The departures are in a list, in time order. In {@code Main.java}, write the method {@code firstOnLine(ArrayList<Departure> departures, String line)}, which returns the index of the first departure of the given line, or -1 if no bus of that line leaves. The check runs:
     * <pre>{@code
     * ArrayList<Departure> departures = new ArrayList<>();
     * departures.add(new Departure("14", "08:05"));
     * departures.add(new Departure("3", "08:12"));
     * departures.add(new Departure("22", "08:20"));
     * departures.add(new Departure("3", "08:31"));
     * System.out.println(firstOnLine(departures, "3"));
     * System.out.println(firstOnLine(departures, "7"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1
     * -1
     * }</pre>
     * Hints
     * 1. Loop over the indexes, {@code for (int i = 0; i < departures.size(); i++)}, so that you have an index to return. {@code departures.get(i).getLine()} is the line of the departure at index {@code i}.
     * 2. Lines are Strings, so compare them with {@code equals}. Return {@code i} at the first match, and -1 after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Departure> departures = new ArrayList<>();
        departures.add(new Departure("14", "08:05"));
        departures.add(new Departure("3", "08:12"));
        departures.add(new Departure("22", "08:20"));
        departures.add(new Departure("3", "08:31"));
        System.out.println(firstOnLine(departures, "3"));
        System.out.println(firstOnLine(departures, "7"));
    }

    // Write the method firstOnLine here.
}
