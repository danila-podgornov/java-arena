// AI-Generated
package module13_lists_ai.step03_getting_values_by_index_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * The list holds the runners of a race, in the order they crossed the finish line. Fill in the blanks so the program prints the top three: see the expected output below.
     * Expected output
     * <pre>{@code
     * Gold: Kofi
     * Silver: Mei
     * Bronze: Lars
     * }</pre>
     * Hints
     * 1. {@code get} takes the index in parentheses, and the first runner is at index 0.
     * 2. The third runner is at index 2.
     */
    public static void main(String[] args) {
        ArrayList<String> finishers = new ArrayList<>();
        finishers.add("Kofi");
        finishers.add("Mei");
        finishers.add("Lars");
        finishers.add("Ines");
        System.out.println("Gold: " + finishers.___);
        System.out.println("Silver: " + finishers.get(1));
        System.out.println("Bronze: " + finishers.get(___));
    }
}
