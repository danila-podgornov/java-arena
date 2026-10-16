// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step04_record_patterns_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A floor plan file has been read into a list of objects: a String for each room's name, and a {@code Corner(int x, int y)} record for each corner of the walls, in centimeters. Write {@code printCorners(ArrayList<Object> items)}, which prints each corner as {@code corner at x, y} and skips everything else. Take the corner apart with a record pattern after {@code instanceof}, without calling the accessors. The check runs:
     * <pre>{@code
     * ArrayList<Object> items = new ArrayList<>();
     * items.add("Kitchen");
     * items.add(new Corner(0, 0));
     * items.add(new Corner(400, 0));
     * items.add("Hall");
     * items.add(new Corner(400, 350));
     * printCorners(items);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * corner at 0, 0
     * corner at 400, 0
     * corner at 400, 350
     * }</pre>
     * Hints
     * 1. Go through the list with {@code for (Object item : items)}.
     * 2. {@code if (item instanceof Corner(int x, int y))} matches the corners only, and gives you {@code x} and {@code y} to print.
     */
    public static void main(String[] args) {
        ArrayList<Object> items = new ArrayList<>();
        items.add("Kitchen");
        items.add(new Corner(0, 0));
        items.add(new Corner(400, 0));
        items.add("Hall");
        items.add(new Corner(400, 350));
        printCorners(items);
    }

    public static void printCorners(ArrayList<Object> items) {

    }
}
