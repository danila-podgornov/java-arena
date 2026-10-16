// AI-Generated
package module31_hash_maps_ai.step05_going_through_a_hash_map_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Challenge03Ai {
    /**
     * A radio station keeps how many times each song was played this week, in a {@code HashMap<String, Integer>} with the titles as keys. Write the method {@code printReport(HashMap<String, Integer> plays, int atLeast)}. It prints each song that was played at least {@code atLeast} times, as the title, {@code : } and the number of plays, in the alphabetical order of the titles. Then it prints {@code Plays in all: } and the plays of all the songs added up, the ones not printed too. The check runs:
     * <pre>{@code
     * HashMap<String, Integer> plays = new HashMap<>();
     * plays.put("Night Bus", 7);
     * plays.put("Slow River", 2);
     * plays.put("Paper Lanterns", 5);
     * plays.put("Blue Tuesday", 9);
     * printReport(plays, 5);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Blue Tuesday: 9
     * Night Bus: 7
     * Paper Lanterns: 5
     * Plays in all: 23
     * }</pre>
     * Hints
     * 1. Go through {@code plays.keySet()}. Add every song's plays to a total, and add the titles with at least {@code atLeast} plays to a list.
     * 2. A HashMap's own order isn't alphabetical, so sort the list with {@code Collections.sort} before printing it. Print the total after the list.
     */
    public static void main(String[] args) {
        HashMap<String, Integer> plays = new HashMap<>();
        plays.put("Night Bus", 7);
        plays.put("Slow River", 2);
        plays.put("Paper Lanterns", 5);
        plays.put("Blue Tuesday", 9);
        printReport(plays, 5);
    }

    // Write the method printReport here.
}
