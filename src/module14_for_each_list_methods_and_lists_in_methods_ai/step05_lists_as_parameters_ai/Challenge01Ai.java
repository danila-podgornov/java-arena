// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step05_lists_as_parameters_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * Write a method {@code groupPrice(ArrayList<Integer> ages)} that returns what a group pays for museum tickets: 12 for each person aged 12 or over, 5 for each child from 3 to 11, and nothing for a child under 3. The check builds a list of the ages 34, 8, 2 and 40, and prints what {@code groupPrice} returns: see the expected output below.
     * Expected output
     * {@code 29}
     * Hints
     * 1. The method starts <code>public static int groupPrice(ArrayList&lt;Integer&gt; ages) {</code>.
     * 2. Start a total at 0. In a for-each loop over the ages, add 12 when {@code age >= 12}, else 5 when {@code age >= 3}, and nothing otherwise. Return the total after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(34);
        ages.add(8);
        ages.add(2);
        ages.add(40);
        System.out.println(groupPrice(ages));
    }

    // Write the groupPrice method here.
}
