// AI-Generated
package module35_interfaces_ai.step06_javas_list_interface_ai;

import java.util.ArrayList;
import java.util.List;

public class Challenge01Ai {
    /**
     * The tram's display shows the route on one line, with {@code >} between the stops. Write the method {@code routeText(List<String> stops)}, which returns that text. There's no {@code >} before the first stop or after the last one, and an empty list gives an empty String. The check runs:
     * <pre>{@code
     * List<String> stops = new ArrayList<>();
     * stops.add("Harbor");
     * stops.add("Old Mill");
     * stops.add("Museum");
     * System.out.println(routeText(stops));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Harbor > Old Mill > Museum}
     * Hints
     * 1. The header is {@code public static String routeText(List<String> stops)}. Inside, {@code stops} has every list method you know: {@code size()}, {@code get(i)}, and a for-each loop works too.
     * 2. Build the text in a String variable. Before every stop except the first (index 0), add {@code >}, then add the stop.
     */
    public static void main(String[] args) {
        List<String> stops = new ArrayList<>();
        stops.add("Harbor");
        stops.add("Old Mill");
        stops.add("Museum");
        System.out.println(routeText(stops));
    }

    // Write the method routeText here.
}
