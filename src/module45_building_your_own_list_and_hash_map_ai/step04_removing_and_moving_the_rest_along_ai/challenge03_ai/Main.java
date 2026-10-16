// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step04_removing_and_moving_the_rest_along_ai.challenge03_ai;

public class Main {
    /**
     * ArrayList's {@code add(int index, E element)} inserts an element at an index, and moves the ones from that index on one place to the right. Add the same to {@code Itinerary.java}: write {@code add(int index, String stop)}.
     * <ul>
     * <li>The index can be from 0 to the size; at the size, the stop goes at the end. Any other index is refused with an IndexOutOfBoundsException with the message {@code Index 5 out of bounds for size 3} (with the index and the size in it), as {@code remove} does.
     * <li>When the array is full, it first grows, just as the other {@code add} does.
     * <li>Then each stop from the index on moves one place to the right, the new stop goes in at the index, and the size goes up by one.
     * </ul>
     * <p>Which way must the loop go this time? The check runs:
     * <pre>{@code
     * Itinerary trip = new Itinerary();
     * trip.add("Lyon");
     * trip.add("Genoa");
     * trip.add("Siena");
     * trip.add(1, "Turin");
     * trip.add(0, "Geneva");
     * trip.add(5, "Rome");
     * System.out.println(trip + ", " + trip.size() + " stops");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Geneva, Lyon, Turin, Genoa, Siena, Rome], 6 stops}
     * Hints
     * 1. Check the index first: refuse it when {@code index < 0 || index > this.size} (the size itself is allowed here). Then grow if {@code this.size == this.stops.length}.
     * 2. Move the stops from the back: {@code for (int i = this.size; i > index; i--) { this.stops[i] = this.stops[i - 1]; }}. From the front, the first move would overwrite the next stop before it moved. Then {@code this.stops[index] = stop;} and {@code this.size++;}.
     */
    public static void main(String[] args) {
        Itinerary trip = new Itinerary();
        trip.add("Lyon");
        trip.add("Genoa");
        trip.add("Siena");
        trip.add(1, "Turin");
        trip.add(0, "Geneva");
        trip.add(5, "Rome");
        System.out.println(trip + ", " + trip.size() + " stops");
    }
}
