// AI-Generated
package module37_streams_and_lambdas_ai.step01_why_streams_filter_and_count_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * The club's app counts the short rides, under 20 km, with a loop. Rewrite the body of {@code shortRides} with a stream: {@code stream()}, {@code filter} and {@code count}, and no loop. Keep the method's header as it is. The check runs:
     * <pre>{@code
     * ArrayList<Integer> rides = new ArrayList<>();
     * rides.add(15);
     * rides.add(42);
     * rides.add(8);
     * rides.add(20);
     * System.out.println(shortRides(rides));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 2}
     * Hints
     * 1. The whole body can be one {@code return} statement: {@code return rides.stream()...;}. {@code count()} already gives a {@code long}, the method's return type.
     * 2. {@code return rides.stream().filter(km -> km < 20).count();}
     */
    public static void main(String[] args) {
        ArrayList<Integer> rides = new ArrayList<>();
        rides.add(15);
        rides.add(42);
        rides.add(8);
        rides.add(20);
        System.out.println(shortRides(rides));
    }

    public static long shortRides(ArrayList<Integer> rides) {
        long count = 0;
        for (int km : rides) {
            if (km < 20) {
                count++;
            }
        }
        return count;
    }
}
