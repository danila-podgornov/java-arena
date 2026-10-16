// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step01_a_list_as_a_value_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Challenge02Ai {
    /**
     * What does this program print? Keep track of which variables refer to which list.
     * Hints
     * 1. {@code debate} and {@code clubs.get("Debate")} refer to the same list object, the one in the map. Two names were added to it, one through each.
     * 2. There's no Astronomy club in the map, so {@code getOrDefault} returns the new list it was given. Leo goes on that list, but nothing ever puts it in the map.
     */
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> clubs = new HashMap<>();
        clubs.put("Debate", new ArrayList<>());
        ArrayList<String> debate = clubs.get("Debate");
        debate.add("Amira");
        clubs.get("Debate").add("Jonas");
        System.out.println(debate.size());

        ArrayList<String> astronomy = clubs.getOrDefault("Astronomy", new ArrayList<>());
        astronomy.add("Leo");
        System.out.println(astronomy);
        System.out.println(clubs.containsKey("Astronomy"));
        System.out.println(clubs.get("Debate"));
    }
}
