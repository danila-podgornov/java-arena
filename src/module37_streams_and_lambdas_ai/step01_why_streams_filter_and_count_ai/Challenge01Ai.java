// AI-Generated
package module37_streams_and_lambdas_ai.step01_why_streams_filter_and_count_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * The club counts the rides of 100 km or more. Fill in the blanks: make a stream of the list, keep the rides of 100 km or more, and count them. The program prints: see the expected output below.
     * Expected output
     * {@code Rides of 100 km or more: 3}
     * Hints
     * 1. The chain starts with the method that turns the list into a stream, then lets through only some values, then counts them.
     * 2. {@code rides.stream()}, then {@code .filter(km -> km >= 100)}, then {@code .count()}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> rides = new ArrayList<>();
        rides.add(104);
        rides.add(35);
        rides.add(120);
        rides.add(99);
        rides.add(100);
        rides.add(47);

        long count = rides.___()
                .___(km -> km >= 100)
                .___();
        System.out.println("Rides of 100 km or more: " + count);
    }
}
