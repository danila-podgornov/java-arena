// AI-Generated
package module37_streams_and_lambdas_ai.step07_reduce_and_intstream_ai;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Challenge01Ai {
    /**
     * What does this program print?
     * Hints
     * 1. The starting value of {@code reduce} takes part in the result, so with {@code Math.max} the result is never less than the start. The end of a {@code range} isn't included; the end of a {@code rangeClosed} is.
     * 2. Every ride is shorter than 50, so the first {@code reduce} keeps 50. {@code map} doubles the rides to 60, 90 and 80, and the second {@code reduce} adds them up from 0. {@code range(2, 6)} is 2, 3, 4 and 5, and {@code rangeClosed(2, 6)} has five values, 2 to 6.
     */
    public static void main(String[] args) {
        ArrayList<Integer> rides = new ArrayList<>();
        rides.add(30);
        rides.add(45);
        rides.add(40);

        int longest = rides.stream()
                .reduce(50, (longestSoFar, km) -> Math.max(longestSoFar, km));
        int doubled = rides.stream()
                .map(km -> 2 * km)
                .reduce(0, (sum, km) -> sum + km);
        System.out.println(longest + " " + doubled);
        System.out.println(IntStream.range(2, 6).sum() + " " + IntStream.rangeClosed(2, 6).count());
    }
}
