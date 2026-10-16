// AI-Generated
package module37_streams_and_lambdas_ai.step04_steps_in_the_middle_map_sorted_distinct_limit_skip_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge01Ai {
    /**
     * The cinema's list has one entry per screening, so a film shown three times is in it three times. Write the method {@code filmsOfTheDay(List<String> screenings)}, which returns a new list of the films, each once, in alphabetical order. Use a stream with {@code distinct}, {@code sorted} and {@code collect(Collectors.toList())}. The check runs:
     * <pre>{@code
     * List<String> screenings = new ArrayList<>();
     * screenings.add("Vertigo");
     * screenings.add("Alien");
     * screenings.add("Heat");
     * screenings.add("Alien");
     * screenings.add("Casablanca");
     * screenings.add("Vertigo");
     * System.out.println(filmsOfTheDay(screenings));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Alien, Casablanca, Heat, Vertigo]}
     * Hints
     * 1. The header is {@code public static List<String> filmsOfTheDay(List<String> screenings)}, and the method returns what the stream collects.
     * 2. {@code return screenings.stream().distinct().sorted().collect(Collectors.toList());} ({@code sorted()} first and {@code distinct()} after it works too).
     */
    public static void main(String[] args) {
        List<String> screenings = new ArrayList<>();
        screenings.add("Vertigo");
        screenings.add("Alien");
        screenings.add("Heat");
        screenings.add("Alien");
        screenings.add("Casablanca");
        screenings.add("Vertigo");
        System.out.println(filmsOfTheDay(screenings));
    }

    // Write the method filmsOfTheDay here.
}
