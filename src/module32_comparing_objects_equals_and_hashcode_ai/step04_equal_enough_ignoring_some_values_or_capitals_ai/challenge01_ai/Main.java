// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step04_equal_enough_ignoring_some_values_or_capitals_ai.challenge01_ai;

import java.util.HashMap;

public class Main {
    /**
     * A rail pass counts the trips made between stations, and station names get typed with any mix of capitals. In {@code Trip.java}, write {@code equals} and {@code hashCode}: two trips are equal when they go from the same station to the same station, whatever the capital letters. Compare the lower-case names in {@code equals}, and give {@code Objects.hash} the lower-case names in {@code hashCode}. The check runs:
     * <pre>{@code
     * HashMap<Trip, Integer> trips = new HashMap<>();
     * trips.put(new Trip("Oakdale", "Harbor"), 3);
     * System.out.println(trips.get(new Trip("OAKDALE", "harbor")));
     * System.out.println(trips.get(new Trip("Harbor", "Oakdale")));
     * System.out.println(new Trip("oakdale", "Harbor").equals(new Trip("Oakdale", "HARBOR")));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * null
     * true
     * }</pre>
     * Hints
     * 1. {@code equals} is the classic one, with Trip in place of Stamp. Its last line compares both names in lower case: {@code this.from.toLowerCase().equals(other.from.toLowerCase())}, then {@code &&} and the same for {@code to}.
     * 2. {@code hashCode} gives the same lower-case names to {@code Objects.hash}: {@code return Objects.hash(this.from.toLowerCase(), this.to.toLowerCase());}. Then trips that {@code equals} calls equal get the same hash code.
     */
    public static void main(String[] args) {
        HashMap<Trip, Integer> trips = new HashMap<>();
        trips.put(new Trip("Oakdale", "Harbor"), 3);
        System.out.println(trips.get(new Trip("OAKDALE", "harbor")));
        System.out.println(trips.get(new Trip("Harbor", "Oakdale")));
        System.out.println(new Trip("oakdale", "Harbor").equals(new Trip("Oakdale", "HARBOR")));
    }
}
