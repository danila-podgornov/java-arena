// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step04_equal_enough_ignoring_some_values_or_capitals_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * {@code Station}'s {@code equals} ignores capital letters, but its {@code hashCode} doesn't. What does this program print?
     * Hints
     * 1. {@code equals} ignores capitals, so {@code OAKDALE} is equal to {@code Oakdale}, and the list's {@code contains}, which uses only {@code equals}, finds it.
     * 2. {@code "OAKDALE"} and {@code "Oakdale"} have different hash codes, so the map looks for the typed station with the wrong hash code and never calls {@code equals}. A new {@code Oakdale} has the same hash code as the key, and is found.
     */
    public static void main(String[] args) {
        ArrayList<Station> visited = new ArrayList<>();
        visited.add(new Station("Oakdale"));
        HashMap<Station, Integer> fares = new HashMap<>();
        fares.put(new Station("Oakdale"), 450);

        Station typed = new Station("OAKDALE");
        System.out.println(typed.equals(new Station("Oakdale")));
        System.out.println(visited.contains(typed));
        System.out.println(fares.get(typed));
        System.out.println(fares.get(new Station("Oakdale")));
    }
}
