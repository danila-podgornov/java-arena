// AI-Generated
package module35_interfaces_ai.step07_javas_map_interface_ai;

import java.util.HashMap;
import java.util.Map;

public class Challenge01Ai {
    /**
     * The baker starts with the bread that has the most loaves ordered. Write the method {@code biggestOrder(Map<String, Integer> orders)}, which returns the kind of bread with the most loaves. The map always has at least one order, and no two kinds have the same number of loaves. The check runs:
     * <pre>{@code
     * Map<String, Integer> orders = new HashMap<>();
     * orders.put("rye", 6);
     * orders.put("sourdough", 10);
     * orders.put("baguette", 7);
     * System.out.println(biggestOrder(orders));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code sourdough}
     * Hints
     * 1. The header is {@code public static String biggestOrder(Map<String, Integer> orders)}. Go through {@code orders.keySet()}, and keep the bread with the most loaves so far.
     * 2. Start with {@code String biggest = null;}. A bread becomes the new biggest when {@code biggest == null}, or when {@code orders.get(bread) > orders.get(biggest)}.
     */
    public static void main(String[] args) {
        Map<String, Integer> orders = new HashMap<>();
        orders.put("rye", 6);
        orders.put("sourdough", 10);
        orders.put("baguette", 7);
        System.out.println(biggestOrder(orders));
    }

    // Write the method biggestOrder here.
}
