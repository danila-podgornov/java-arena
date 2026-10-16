// AI-Generated
package module13_lists_ai.step04_when_the_index_doesnt_exist_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * This program crashes. Run it, read the message, and fix the mistake, so the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * First stop: Station
     * Second stop: Library
     * Last stop: Harbor
     * }</pre>
     * Hints
     * 1. The message says index 3, for a list of length 3: its indexes only go up to 2.
     * 2. All three indexes are one too big. The first stop is at index 0.
     */
    public static void main(String[] args) {
        ArrayList<String> stops = new ArrayList<>();
        stops.add("Station");
        stops.add("Library");
        stops.add("Harbor");
        System.out.println("First stop: " + stops.get(1));
        System.out.println("Second stop: " + stops.get(2));
        System.out.println("Last stop: " + stops.get(3));
    }
}
