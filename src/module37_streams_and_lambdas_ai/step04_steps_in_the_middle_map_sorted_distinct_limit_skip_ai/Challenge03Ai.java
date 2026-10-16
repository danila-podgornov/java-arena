// AI-Generated
package module37_streams_and_lambdas_ai.step04_steps_in_the_middle_map_sorted_distinct_limit_skip_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge03Ai {
    /**
     * The cinema wants to know its quietest screenings. Write the method {@code quietest(List<Integer> tickets, int n)}, which returns a new list of the {@code n} smallest ticket counts, from the smallest up. If the list has fewer than {@code n} values, it returns all of them, sorted. The list it gets must stay as it was. Use a stream. The check runs:
     * <pre>{@code
     * List<Integer> tickets = new ArrayList<>();
     * tickets.add(85);
     * tickets.add(140);
     * tickets.add(32);
     * tickets.add(120);
     * tickets.add(64);
     * System.out.println(quietest(tickets, 2));
     * System.out.println(tickets);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [32, 64]
     * [85, 140, 32, 120, 64]
     * }</pre>
     * Hints
     * 1. The header is {@code public static List<Integer> quietest(List<Integer> tickets, int n)}. Sort first, and then keep the first {@code n}: the other order keeps the first {@code n} of the day.
     * 2. {@code return tickets.stream().sorted().limit(n).collect(Collectors.toList());} A {@code limit} bigger than the number of values lets them all through.
     */
    public static void main(String[] args) {
        List<Integer> tickets = new ArrayList<>();
        tickets.add(85);
        tickets.add(140);
        tickets.add(32);
        tickets.add(120);
        tickets.add(64);
        System.out.println(quietest(tickets, 2));
        System.out.println(tickets);
    }

    // Write the method quietest here.
}
