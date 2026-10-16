// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step03_several_criteria_and_sorted_streams_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     * The airport's app shows the next departures from a given time on. {@code Flight.java} is the lesson's. In {@code Main.java}, write the method {@code nextDepartures(List<Flight> flights, String time, int count)}, which returns a list of the destinations of the first {@code count} flights that depart at {@code time} or later, in the order they depart. It shouldn't change the list it's given. Use one stream with {@code filter}, {@code sorted} with a comparator, {@code limit}, {@code map} and {@code collect}.
     * <p>The times are Strings like {@code 09:05}. A flight departs at {@code time} or later when {@code flight.getDeparts().compareTo(time) >= 0}. The check runs:
     * <pre>{@code
     * List<Flight> flights = new ArrayList<>();
     * flights.add(new Flight("Lisbon", "13:10", 4));
     * flights.add(new Flight("Oslo", "07:45", 12));
     * flights.add(new Flight("Dublin", "09:30", 7));
     * flights.add(new Flight("Athens", "18:20", 2));
     * flights.add(new Flight("Riga", "09:05", 12));
     * System.out.println(nextDepartures(flights, "09:00", 3));
     * System.out.println(nextDepartures(flights, "12:00", 5));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Riga, Dublin, Lisbon]
     * [Lisbon, Athens]
     * }</pre>
     * Hints
     * 1. The header is {@code public static List<String> nextDepartures(List<Flight> flights, String time, int count)}. The filter keeps the flights with {@code flight.getDeparts().compareTo(time) >= 0}.
     * 2. Then {@code .sorted(Comparator.comparing(Flight::getDeparts))}, {@code .limit(count)}, {@code .map(Flight::getDestination)} and {@code .collect(Collectors.toList())}. Sort before {@code limit}, so that the first flights are the earliest ones.
     */
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Lisbon", "13:10", 4));
        flights.add(new Flight("Oslo", "07:45", 12));
        flights.add(new Flight("Dublin", "09:30", 7));
        flights.add(new Flight("Athens", "18:20", 2));
        flights.add(new Flight("Riga", "09:05", 12));
        System.out.println(nextDepartures(flights, "09:00", 3));
        System.out.println(nextDepartures(flights, "12:00", 5));
    }

    // Write the method nextDepartures here.
}
