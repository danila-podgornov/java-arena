// AI-Generated
package module19_objects_in_a_list_ai.step03_several_values_for_each_object_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Each line of the input is a trip: a city and the number of days, separated by a comma, like {@code Oslo,5}. The input ends with an empty line. {@code Trip.java} is ready. Read the lines, split each one and add a {@code Trip} to the list {@code trips}. Then print every trip, and last {@code Total: } with the days of all the trips added up. For the input {@code Oslo,5}, {@code Rome,3}, {@code Lima,4} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Oslo, 5 days
     * Rome, 3 days
     * Lima, 4 days
     * Total: 12 days
     * }</pre>
     * Hints
     * 1. {@code String[] parts = line.split(",");} gives the city in {@code parts[0]} and the days, as text, in {@code parts[1]}. {@code Integer.valueOf(parts[1])} makes a number of them.
     * 2. In the loop that prints the trips, also add up {@code trip.getDays()}. Print the total after that loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Trip> trips = new ArrayList<>();

    }
}
