// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step04_fast_lookups_and_the_end_of_part_8_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Challenge02Ai {
    /**
     * The library desk keeps every scan in a list, counts the scans of each card in a map, and remembers, in a second map, the index of each card's latest scan. What does this program print?
     * Hints
     * 1. The list keeps every scan, so it has 5 elements. Each map keeps every card once, as a key: there are 3 different cards.
     * 2. {@code indexOf} finds the first scan of S-104. In {@code lastScan}, each new scan of a card replaces the index stored before, so the map keeps the latest one.
     */
    public static void main(String[] args) {
        String[] scans = {"S-104", "S-231", "S-104", "S-087", "S-104"};
        ArrayList<String> history = new ArrayList<>();
        HashMap<String, Integer> counts = new HashMap<>();
        HashMap<String, Integer> lastScan = new HashMap<>();
        for (int i = 0; i < scans.length; i++) {
            history.add(scans[i]);
            counts.put(scans[i], counts.getOrDefault(scans[i], 0) + 1);
            lastScan.put(scans[i], i);
        }
        System.out.println(history.size() + " " + counts.size());
        System.out.println(history.get(2) + " " + counts.get("S-104"));
        System.out.println(history.indexOf("S-104") + " " + lastScan.get("S-104"));
        System.out.println(history.contains("S-500") + " " + counts.containsKey("S-087"));
    }
}
