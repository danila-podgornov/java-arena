// AI-Generated
package module31_hash_maps_ai.step03_objects_as_values_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * {@code Airport.java} is ready: an airport has a code, a city and a country, with getters and a toString. In {@code Main.java}, write the method {@code byCode(ArrayList<Airport> airports)}. It makes a new {@code HashMap<String, Airport>}, puts every airport of the list in it with the airport's code as the key, and returns the map. The check runs:
     * <pre>{@code
     * ArrayList<Airport> list = new ArrayList<>();
     * list.add(new Airport("OSL", "Oslo", "Norway"));
     * list.add(new Airport("ICN", "Seoul", "South Korea"));
     * list.add(new Airport("MEX", "Mexico City", "Mexico"));
     * HashMap<String, Airport> airports = byCode(list);
     * System.out.println(airports.get("ICN"));
     * System.out.println(airports.get("MEX").getCity());
     * System.out.println(airports.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Seoul, South Korea (ICN)
     * Mexico City
     * 3
     * }</pre>
     * Hints
     * 1. The method starts <code>public static HashMap&lt;String, Airport&gt; byCode(ArrayList&lt;Airport&gt; airports) {</code>, and its first line makes the map: {@code HashMap<String, Airport> map = new HashMap<>();}.
     * 2. Go through the list with a for-each loop, and put each airport in the map with {@code map.put(airport.getCode(), airport);}. After the loop, return the map.
     */
    public static void main(String[] args) {
        ArrayList<Airport> list = new ArrayList<>();
        list.add(new Airport("OSL", "Oslo", "Norway"));
        list.add(new Airport("ICN", "Seoul", "South Korea"));
        list.add(new Airport("MEX", "Mexico City", "Mexico"));
        HashMap<String, Airport> airports = byCode(list);
        System.out.println(airports.get("ICN"));
        System.out.println(airports.get("MEX").getCity());
        System.out.println(airports.size());
    }

    // Write the method byCode here.
}
