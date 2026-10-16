// AI-Generated
package module31_hash_maps_ai.step02_one_value_per_key_ai;

import java.util.HashMap;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A radio station takes song requests by text message, and people type the titles any way they like. The map {@code catalog} has every song the station can play, with the title in small letters as the key and the artist as the value. Read requests, one per line, until an empty line. Tidy each title with {@code trim()} and {@code toLowerCase()}, and then print either {@code Playing }, the tidied title, {@code by} and the artist, or {@code Not in the catalog: } and the tidied title. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Playing night bus by Mira Vale
     * Playing paper lanterns by The Quiet Hours
     * Not in the catalog: blue tuesday
     * }</pre>
     * Hints
     * 1. Read in a {@code while (true)} loop that stops with {@code break} at the empty line. Tidy each line with {@code line.trim().toLowerCase()} before looking it up.
     * 2. {@code catalog.get(title)} gives the artist, or {@code null} for a title the station doesn't have.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> catalog = new HashMap<>();
        catalog.put("paper lanterns", "The Quiet Hours");
        catalog.put("night bus", "Mira Vale");
        catalog.put("cedar smoke", "Juniper Road");
        catalog.put("slow river", "The Quiet Hours");

        // Read the requests here.
    }
}
