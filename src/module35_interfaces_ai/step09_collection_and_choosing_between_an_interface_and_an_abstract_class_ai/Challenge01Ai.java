// AI-Generated
package module35_interfaces_ai.step09_collection_and_choosing_between_an_interface_and_an_abstract_class_ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Challenge01Ai {
    /**
     * Write the method {@code countAtLeast(Collection<Integer> numbers, int limit)}, which returns how many of the numbers are at least {@code limit}. The check calls it with a list, a set and a map's values:
     * <pre>{@code
     * List<Integer> hourly = new ArrayList<>();
     * hourly.add(300);
     * hourly.add(450);
     * hourly.add(300);
     * hourly.add(120);
     * System.out.println(countAtLeast(hourly, 300));
     * System.out.println(countAtLeast(new HashSet<>(hourly), 300));
     * Map<String, Integer> watts = new HashMap<>();
     * watts.put("heater", 1500);
     * watts.put("fan", 60);
     * watts.put("kettle", 2000);
     * System.out.println(countAtLeast(watts.values(), 1000));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 2
     * 2
     * }</pre>
     * Hints
     * 1. The header is {@code public static int countAtLeast(Collection<Integer> numbers, int limit)}. A Collection has no {@code get(index)}, so go through it with a for-each loop.
     * 2. Count the numbers for which {@code number >= limit}, and return the count. The set holds 300 only once, so it gives one less than the list.
     */
    public static void main(String[] args) {
        List<Integer> hourly = new ArrayList<>();
        hourly.add(300);
        hourly.add(450);
        hourly.add(300);
        hourly.add(120);
        System.out.println(countAtLeast(hourly, 300));
        System.out.println(countAtLeast(new HashSet<>(hourly), 300));
        Map<String, Integer> watts = new HashMap<>();
        watts.put("heater", 1500);
        watts.put("fan", 60);
        watts.put("kettle", 2000);
        System.out.println(countAtLeast(watts.values(), 1000));
    }

    // Write the method countAtLeast here.
}
