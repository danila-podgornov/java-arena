// AI-Generated
package module31_hash_maps_ai.step05_going_through_a_hash_map_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Challenge01Ai {
    /**
     * Fill in the blanks of {@code printAirports}, which prints every code and city of the map, one per line, in the alphabetical order of the codes. The check runs:
     * <pre>{@code
     * HashMap<String, String> airports = new HashMap<>();
     * airports.put("SYD", "Sydney");
     * airports.put("AKL", "Auckland");
     * airports.put("DXB", "Dubai");
     * airports.put("KEF", "Reykjavik");
     * printAirports(airports);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * AKL Auckland
     * DXB Dubai
     * KEF Reykjavik
     * SYD Sydney
     * }</pre>
     * Hints
     * 1. The list is a copy of the map's keys, which {@code keySet()} gives. {@code Collections.sort} then puts the codes in alphabetical order.
     * 2. The loop goes through the sorted codes, and each city comes from the map: {@code airports.get(code)}.
     */
    public static void main(String[] args) {
        HashMap<String, String> airports = new HashMap<>();
        airports.put("SYD", "Sydney");
        airports.put("AKL", "Auckland");
        airports.put("DXB", "Dubai");
        airports.put("KEF", "Reykjavik");
        printAirports(airports);
    }

    public static void printAirports(HashMap<String, String> airports) {
        ArrayList<String> codes = new ArrayList<>(airports.___());
        Collections.___(codes);
        for (String code : codes) {
            System.out.println(code + " " + airports.___(code));
        }
    }
}
