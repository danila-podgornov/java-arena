// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step04_removing_and_moving_the_rest_along_ai.challenge01_ai;

public class Main {
    /**
     * A road trip planner keeps its stops in a list of its own. Fill in the three blanks of {@code remove} in {@code Itinerary.java}: how far the loop goes, the index each place takes its stop from, and the last statement, which updates the size. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Turin is off the trip
     * Rome is off the trip
     * [Lyon, Genoa, Pisa, Siena], 4 stops
     * }</pre>
     * Hints
     * 1. Each place takes the stop from the place after it. The last place that takes a stop is the second-to-last one: one round more would read past the last stop, outside a full array. And at the end the list has one stop fewer.
     * 2. The loop goes while {@code i < this.size - 1}, and each round reads {@code this.stops[i + 1]}. With {@code i < this.size}, the last round would read {@code this.stops[this.size]}. The last statement is {@code this.size--;}.
     */
    public static void main(String[] args) {
        Itinerary trip = new Itinerary();
        trip.add("Lyon");
        trip.add("Turin");
        trip.add("Genoa");
        trip.add("Pisa");
        System.out.println(trip.remove(1) + " is off the trip");
        trip.add("Siena");
        trip.add("Rome");
        System.out.println(trip.remove(4) + " is off the trip");
        System.out.println(trip + ", " + trip.size() + " stops");
    }
}
