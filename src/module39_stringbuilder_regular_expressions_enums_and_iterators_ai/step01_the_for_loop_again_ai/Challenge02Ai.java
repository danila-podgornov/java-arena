// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step01_the_for_loop_again_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. The first loop prints 10, 6 and 2. The next value, -2, isn't above 0, so the loop stops there.
     * 2. The second loop starts from the last index, 4, and goes down by 2: index 4, then 2. (Index 0 fails {@code i >= 1}.) Each round prints a height minus the one right before it.
     */
    public static void main(String[] args) {
        for (int i = 10; i > 0; i -= 4) {
            System.out.println(i);
        }

        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(20);
        heights.add(26);
        heights.add(29);
        heights.add(41);
        heights.add(50);
        for (int i = heights.size() - 1; i >= 1; i -= 2) {
            System.out.println(heights.get(i) - heights.get(i - 1));
        }
    }
}
