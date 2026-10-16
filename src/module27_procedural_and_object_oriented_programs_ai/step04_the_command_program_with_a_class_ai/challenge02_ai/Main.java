// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step04_the_command_program_with_a_class_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * The box office now sells tickets for two shows: an afternoon show with 120 seats, and an evening show with 200. {@code Concert.java} is the class above, unchanged. Write {@code main}: create one Concert for each show, and read commands, with the prompt {@code > } before each one:
     * <ul>
     * <li>{@code afternoon}: the next line is a number of tickets. Sell them for the afternoon show, and print {@code Sold! Tickets left: } and the tickets left for that show. If they don't fit, print {@code Sorry, tickets left: } and the tickets left.
     * <li>{@code evening}: the same, for the evening show.
     * <li>{@code status}: print the tickets left for both shows, like {@code Afternoon: 20 left, evening: 150 left}.
     * <li>{@code quit}: print {@code Box office closed} and end the program.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Sold! Tickets left: 20
     * > Sold! Tickets left: 150
     * > Sorry, tickets left: 20
     * > Afternoon: 20 left, evening: 150 left
     * > Box office closed
     * }</pre>
     * Hints
     * 1. Create {@code Concert afternoon = new Concert(120);} and {@code Concert evening = new Concert(200);} before the loop. The loop is shaped like the box office's, with {@code afternoon} and {@code evening} in the place of {@code sell}.
     * 2. The answer to a sale is the same for both shows, so a static method in {@code Main}, such as {@code sellTickets(Concert concert, int count)}, can print it for either one: both styles in one program. Call it with {@code afternoon} or with {@code evening}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create the two concerts, then write the command loop.
    }
}
