// AI-Generated
package module31_hash_maps_ai.step01_keys_and_values_ai;

import java.util.HashMap;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A travel desk looks up airport codes. Fill in the blanks. The program reads one airport code. If the map has it, the program prints the code and its city, like {@code NBO is in Nairobi}. If it doesn't, it prints {@code No airport with the code } and the code. For the input {@code NBO}, it prints: see the expected output below.
     * Expected output
     * {@code NBO is in Nairobi}
     * Hints
     * 1. {@code put(key, value)} adds a pair to the map, like the three lines after it. {@code get(key)} gives the value linked to a key.
     * 2. For a code that isn't in the map, {@code get} gives {@code null}, so that's what {@code city} is compared with.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> airports = new HashMap<>();
        airports.___("KEF", "Reykjavik");
        airports.put("NBO", "Nairobi");
        airports.put("AKL", "Auckland");
        airports.put("CPT", "Cape Town");

        String code = scanner.nextLine();
        String city = airports.___(code);
        if (city == ___) {
            System.out.println("No airport with the code " + code);
        } else {
            System.out.println(code + " is in " + city);
        }
    }
}
