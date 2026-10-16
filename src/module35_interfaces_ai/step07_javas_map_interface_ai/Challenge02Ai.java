// AI-Generated
package module35_interfaces_ai.step07_javas_map_interface_ai;

import java.util.HashMap;
import java.util.Map;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. A second {@code put} with the key {@code rye} replaces its value. {@code addLoaves} gets the same map object, so what it puts is in {@code orders}.
     * 2. Spelt goes from 2 to 6, and bagel starts from 0. After {@code remove}, rye isn't in the map, so {@code getOrDefault} gives the default, 0.
     */
    public static void main(String[] args) {
        Map<String, Integer> orders = new HashMap<>();
        orders.put("rye", 3);
        orders.put("spelt", 2);
        orders.put("rye", 5);
        addLoaves(orders, "spelt", 4);
        addLoaves(orders, "bagel", 12);
        orders.remove("rye");
        System.out.println(orders.size() + " " + orders.get("spelt"));
        System.out.println(orders.getOrDefault("rye", 0) + " " + orders.containsKey("bagel"));
    }

    public static void addLoaves(Map<String, Integer> orders, String bread, int loaves) {
        orders.put(bread, orders.getOrDefault(bread, 0) + loaves);
    }
}
