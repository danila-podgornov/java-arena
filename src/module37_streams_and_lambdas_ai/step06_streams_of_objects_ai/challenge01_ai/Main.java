// AI-Generated
package module37_streams_and_lambdas_ai.step06_streams_of_objects_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * {@code Ride.java} is ready. In {@code Main.java}, write the method {@code totalKm(List<Ride> rides, String rider)}, which returns the total distance of the given rider's rides, as an {@code int}, and 0 if the rider has none. Use a stream. The check runs:
     * <pre>{@code
     * List<Ride> rides = new ArrayList<>();
     * rides.add(new Ride("Noor", 42));
     * rides.add(new Ride("Pablo", 65));
     * rides.add(new Ride("Noor", 18));
     * System.out.println(totalKm(rides, "Noor"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 60}
     * Hints
     * 1. The header is {@code public static int totalKm(List<Ride> rides, String rider)}. Keep the given rider's rides with a filter that compares {@code ride.getRider()} with {@code rider} using {@code equals}.
     * 2. After the filter, {@code mapToInt(Ride::getKm)} and {@code sum()}. The sum of an empty stream is 0.
     */
    public static void main(String[] args) {
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride("Noor", 42));
        rides.add(new Ride("Pablo", 65));
        rides.add(new Ride("Noor", 18));
        System.out.println(totalKm(rides, "Noor"));
    }

    // Write the method totalKm here.
}
