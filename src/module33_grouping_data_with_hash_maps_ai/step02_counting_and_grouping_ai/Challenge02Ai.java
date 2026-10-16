// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step02_counting_and_grouping_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Challenge02Ai {
    /**
     * A shopping list is grouped by the first letter of each item. What does this program print? Look closely at every word's first letter.
     * Hints
     * 1. A list can hold the same value twice, so both apples go on the list of {@code a}. {@code Avocado} starts with a capital A, and {@code "A"} is a different String from {@code "a"}, so it's a different key.
     * 2. Count the keys: {@code a}, {@code b}, {@code A} and {@code c}. {@code groups.size()} is the number of keys, not the number of items.
     */
    public static void main(String[] args) {
        String[] items = {"apple", "bread", "Avocado", "butter", "apple", "cheese"};
        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        for (String item : items) {
            String first = item.substring(0, 1);
            if (!groups.containsKey(first)) {
                groups.put(first, new ArrayList<>());
            }
            groups.get(first).add(item);
        }
        System.out.println(groups.get("a"));
        System.out.println(groups.get("b").size());
        System.out.println(groups.size());
        System.out.println(groups.containsKey("A"));
    }
}
