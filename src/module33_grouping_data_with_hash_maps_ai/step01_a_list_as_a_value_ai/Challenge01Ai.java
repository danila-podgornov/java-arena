// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step01_a_list_as_a_value_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Challenge01Ai {
    /**
     * A community garden keeps a list of the plants in each bed. Fill in the blanks of {@code plant(beds, bed, plant)}, which adds a plant to the bed's list, and creates the list for the bed's first plant. The check runs:
     * <pre>{@code
     * HashMap<String, ArrayList<String>> beds = new HashMap<>();
     * plant(beds, "North", "kale");
     * plant(beds, "South", "beans");
     * plant(beds, "North", "leeks");
     * System.out.println(beds.get("North"));
     * System.out.println(beds.get("South"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [kale, leeks]
     * [beans]
     * }</pre>
     * Hints
     * 1. It works like {@code join} above. The {@code if} asks whether the map already has the bed as a key, and the {@code !} makes it run only when it doesn't.
     * 2. The bed's first plant needs a new, empty list: {@code new ArrayList<>()}. After the {@code if}, {@code beds.get(bed)} is the bed's list in the map, and {@code add} puts the plant on it.
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> beds = new HashMap<>();
        plant(beds, "North", "kale");
        plant(beds, "South", "beans");
        plant(beds, "North", "leeks");
        System.out.println(beds.get("North"));
        System.out.println(beds.get("South"));
    }

    public static void plant(HashMap<String, ArrayList<String>> beds, String bed, String plant) {
        if (!beds.___(bed)) {
            beds.put(bed, ___);
        }
        beds.___(bed).add(plant);
    }
}
