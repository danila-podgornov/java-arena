// AI-Generated
package module31_hash_maps_ai.step05_going_through_a_hash_map_ai;

import java.util.HashMap;

public class Challenge02Ai {
    /**
     * A museum's audio guide keeps how many times each stop was played, with the stop numbers as keys. What does this program print? One stop is put twice.
     * Hints
     * 1. The second {@code put} for stop 12 replaces 40 with 25, so the map has three pairs, with the values 25, 15 and 8. The first loop adds them up.
     * 2. The second loop counts the stops whose value is at least 15. The order the loops go in doesn't matter for a total or a count.
     */
    public static void main(String[] args) {
        HashMap<Integer, Integer> listens = new HashMap<>();
        listens.put(12, 40);
        listens.put(27, 15);
        listens.put(31, 8);
        listens.put(12, 25);

        int total = 0;
        for (int count : listens.values()) {
            total += count;
        }
        int popular = 0;
        for (int stop : listens.keySet()) {
            if (listens.get(stop) >= 15) {
                popular++;
            }
        }
        System.out.println(total);
        System.out.println(popular);
        System.out.println(listens.size());
    }
}
