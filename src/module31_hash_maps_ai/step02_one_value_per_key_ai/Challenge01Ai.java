// AI-Generated
package module31_hash_maps_ai.step02_one_value_per_key_ai;

import java.util.HashMap;

public class Challenge01Ai {
    /**
     * What does this program print? One room is put twice, and one guest's name is in the map twice.
     * Hints
     * 1. Room 101 is put twice. A key has at most one value, so the second {@code put} replaces Moreau with Kowalski instead of adding a pair. Achebe in two rooms is fine: the rooms are different keys.
     * 2. Removing 102 takes that pair out. The map has no room 104, so removing it changes nothing.
     */
    public static void main(String[] args) {
        HashMap<Integer, String> guests = new HashMap<>();
        guests.put(101, "Moreau");
        guests.put(102, "Achebe");
        guests.put(101, "Kowalski");
        guests.put(103, "Achebe");
        System.out.println(guests.size());
        System.out.println(guests.get(101));
        guests.remove(102);
        guests.remove(104);
        System.out.println(guests.containsKey(102) + " " + guests.size());
        System.out.println(guests.get(103));
    }
}
