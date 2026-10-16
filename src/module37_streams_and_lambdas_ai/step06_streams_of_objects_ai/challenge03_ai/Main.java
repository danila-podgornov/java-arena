// AI-Generated
package module37_streams_and_lambdas_ai.step06_streams_of_objects_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     * {@code Screening.java} is ready: a screening has a film, the number of tickets sold and the number of seats, and {@code isSoldOut()} says whether every seat is sold. In {@code Main.java}, write the method {@code soldOutFilms(List<Screening> screenings)}, which returns a new list of the films that had at least one sold-out screening, each once, in alphabetical order. Use a stream, and {@code Screening::isSoldOut} in the filter. The check runs:
     * <pre>{@code
     * List<Screening> screenings = new ArrayList<>();
     * screenings.add(new Screening("Vertigo", 120, 120));
     * screenings.add(new Screening("Heat", 64, 90));
     * screenings.add(new Screening("Alien", 90, 90));
     * screenings.add(new Screening("Vertigo", 80, 80));
     * System.out.println(soldOutFilms(screenings));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Alien, Vertigo]}
     * Hints
     * 1. The header is {@code public static List<String> soldOutFilms(List<Screening> screenings)}. {@code filter(Screening::isSoldOut)} keeps the sold-out screenings: the method returns the {@code true} or {@code false} that the filter needs.
     * 2. Then {@code map(Screening::getFilm)} turns each screening into its film, and {@code distinct()}, {@code sorted()} and {@code collect(Collectors.toList())} finish the job.
     */
    public static void main(String[] args) {
        List<Screening> screenings = new ArrayList<>();
        screenings.add(new Screening("Vertigo", 120, 120));
        screenings.add(new Screening("Heat", 64, 90));
        screenings.add(new Screening("Alien", 90, 90));
        screenings.add(new Screening("Vertigo", 80, 80));
        System.out.println(soldOutFilms(screenings));
    }

    // Write the method soldOutFilms here.
}
