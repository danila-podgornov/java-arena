// AI-Generated
package module37_streams_and_lambdas_ai.step06_streams_of_objects_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * What does this program print?
     * Hints
     * 1. {@code >=} lets a ride of exactly 30 km through. {@code distinct} keeps the first copy of each name, in the list's order, and nothing sorts them. In the second stream, each distance is divided by 10 as an {@code int} before the sum.
     * 2. Kaia's 30, Noor's 75 and Kaia's 90 get through the first filter, {@code map} turns them into Kaia, Noor and Kaia, and {@code distinct} drops the second Kaia. Kaia's are the only rides by a name that starts with K, and {@code mapToInt} gives 3 and 9 for them.
     */
    public static void main(String[] args) {
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride("Kaia", 30));
        rides.add(new Ride("Noor", 75));
        rides.add(new Ride("Kaia", 90));
        rides.add(new Ride("Pablo", 20));

        rides.stream()
                .filter(ride -> ride.getKm() >= 30)
                .map(Ride::getRider)
                .distinct()
                .forEach(System.out::println);
        int total = rides.stream()
                .filter(ride -> ride.getRider().startsWith("K"))
                .mapToInt(ride -> ride.getKm() / 10)
                .sum();
        System.out.println(total);
    }
}
