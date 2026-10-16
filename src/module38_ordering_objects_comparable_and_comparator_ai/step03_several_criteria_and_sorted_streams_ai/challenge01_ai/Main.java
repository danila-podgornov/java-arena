// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step03_several_criteria_and_sorted_streams_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    /**
     * A tea shop prints its menu with the cheapest teas first, and teas of the same price in alphabetical order. {@code Tea.java} is ready. In {@code Main.java}, write the method {@code sortMenu(List<Tea> teas)}, which sorts the list that way. Use {@code Comparator.comparing} and {@code thenComparing}. The check runs:
     * <pre>{@code
     * List<Tea> menu = new ArrayList<>();
     * menu.add(new Tea("Sencha", 6));
     * menu.add(new Tea("Earl Grey", 4));
     * menu.add(new Tea("Oolong", 6));
     * menu.add(new Tea("Chai", 4));
     * menu.add(new Tea("Matcha", 9));
     * sortMenu(menu);
     * System.out.println(menu);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Chai $4, Earl Grey $4, Oolong $6, Sencha $6, Matcha $9]}
     * Hints
     * 1. The header is {@code public static void sortMenu(List<Tea> teas)}, and its body is one call of {@code teas.sort(...)}.
     * 2. The price comes first and the name second: {@code teas.sort(Comparator.comparing(Tea::getPrice).thenComparing(Tea::getName));}.
     */
    public static void main(String[] args) {
        List<Tea> menu = new ArrayList<>();
        menu.add(new Tea("Sencha", 6));
        menu.add(new Tea("Earl Grey", 4));
        menu.add(new Tea("Oolong", 6));
        menu.add(new Tea("Chai", 4));
        menu.add(new Tea("Matcha", 9));
        sortMenu(menu);
        System.out.println(menu);
    }

    // Write the method sortMenu here.
}
