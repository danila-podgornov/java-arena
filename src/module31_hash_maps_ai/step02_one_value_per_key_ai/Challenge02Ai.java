// AI-Generated
package module31_hash_maps_ai.step02_one_value_per_key_ai;

import java.util.HashMap;

public class Challenge02Ai {
    /**
     * A pantry keeps its jars in a {@code HashMap<String, Integer>}: each food, and how many jars of it there are. A food is in the map only while there's at least one jar of it. Write the method {@code useOne(HashMap<String, Integer> jars, String food)}. If the pantry has the food, the method takes one jar away and returns {@code true}, and when that was the last jar, it removes the food from the map. If the pantry has no such food, the method changes nothing and returns {@code false}. The check runs:
     * <pre>{@code
     * HashMap<String, Integer> jars = new HashMap<>();
     * jars.put("marmalade", 2);
     * jars.put("olives", 1);
     * System.out.println(useOne(jars, "marmalade") + " " + jars.get("marmalade"));
     * System.out.println(useOne(jars, "olives") + " " + jars.containsKey("olives"));
     * System.out.println(useOne(jars, "olives") + " " + jars.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true 1
     * true false
     * false 1
     * }</pre>
     * Hints
     * 1. Start with {@code if (!jars.containsKey(food)) { return false; }}. After that, the food is surely in the map, so {@code jars.get(food)} is a number, not {@code null}.
     * 2. Work out the jars that are left, {@code jars.get(food) - 1}. When that's 0, {@code remove} the food; otherwise {@code put} the new count, which replaces the old one.
     */
    public static void main(String[] args) {
        HashMap<String, Integer> jars = new HashMap<>();
        jars.put("marmalade", 2);
        jars.put("olives", 1);
        System.out.println(useOne(jars, "marmalade") + " " + jars.get("marmalade"));
        System.out.println(useOne(jars, "olives") + " " + jars.containsKey("olives"));
        System.out.println(useOne(jars, "olives") + " " + jars.size());
    }

    // Write the method useOne here.
}
