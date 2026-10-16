// AI-Generated
package module13_lists_ai.step06_looping_over_a_list_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * What does this program print? Work out which indexes each loop visits.
     * Hints
     * 1. The list has 6 values, at indexes 0 to 5. The first loop visits indexes 2 and 5.
     * 2. The second loop starts at index 4 and visits 4 and 2. At 0 the condition {@code i > 0} is false, so index 0 is left out.
     */
    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        letters.add("f");
        for (int i = 2; i < letters.size(); i += 3) {
            System.out.println(letters.get(i));
        }
        for (int i = letters.size() - 2; i > 0; i -= 2) {
            System.out.println(letters.get(i));
        }
    }
}
