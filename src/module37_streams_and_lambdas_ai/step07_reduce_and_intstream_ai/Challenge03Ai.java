// AI-Generated
package module37_streams_and_lambdas_ai.step07_reduce_and_intstream_ai;

import java.util.ArrayList;
import java.util.List;

public class Challenge03Ai {
    /**
     * Write the method {@code longestRide(List<Integer> rides)}, which returns the longest ride, and 0 for an empty list. Use {@code reduce} with {@code Math.max}. The check runs:
     * <pre>{@code
     * List<Integer> rides = new ArrayList<>();
     * rides.add(42);
     * rides.add(65);
     * rides.add(18);
     * System.out.println(longestRide(rides));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 65}
     * Hints
     * 1. The header is {@code public static int longestRide(List<Integer> rides)}. Start {@code reduce} at 0: that's also what it returns for an empty list.
     * 2. {@code return rides.stream().reduce(0, (longest, km) -> Math.max(longest, km));}
     */
    public static void main(String[] args) {
        List<Integer> rides = new ArrayList<>();
        rides.add(42);
        rides.add(65);
        rides.add(18);
        System.out.println(longestRide(rides));
    }

    // Write the method longestRide here.
}
