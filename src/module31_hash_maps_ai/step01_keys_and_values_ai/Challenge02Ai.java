// AI-Generated
package module31_hash_maps_ai.step01_keys_and_values_ai;

import java.util.HashMap;

public class Challenge02Ai {
    /**
     * What does this program print? One of the foods isn't in the pantry.
     * Hints
     * 1. {@code get} gives the value of a key that's in the map, and {@code null} for one that isn't: there's no ketchup.
     * 2. {@code getOrDefault} uses the fallback only for a missing key. Plum jam is in the map, so the last line adds its 4 jars, not 10, to the 2 jars of marmalade.
     */
    public static void main(String[] args) {
        HashMap<String, Integer> jars = new HashMap<>();
        jars.put("plum jam", 4);
        jars.put("marmalade", 2);
        jars.put("mustard", 6);
        System.out.println(jars.get("marmalade"));
        System.out.println(jars.get("ketchup"));
        System.out.println(jars.getOrDefault("mustard", 0));
        System.out.println(jars.getOrDefault("ketchup", 0));
        System.out.println(jars.getOrDefault("plum jam", 10) + jars.get("marmalade"));
    }
}
