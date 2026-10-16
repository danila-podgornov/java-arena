// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step06_one_list_two_names_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * Write a method {@code capAt(ArrayList<Integer> levels, int max)} that changes the list itself: every value above {@code max} becomes {@code max}. It returns nothing. The check builds a list of 40, 120, 75 and 101, calls {@code capAt(levels, 100);}, and then prints the list: see the expected output below.
     * Expected output
     * {@code [40, 100, 75, 100]}
     * Hints
     * 1. The method is {@code void}: it changes the caller's list, so there's nothing to return.
     * 2. An index loop, and inside it {@code if (levels.get(i) > max) { levels.set(i, max); }}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> levels = new ArrayList<>();
        levels.add(40);
        levels.add(120);
        levels.add(75);
        levels.add(101);
        capAt(levels, 100);
        System.out.println(levels);
    }

    // Write the capAt method here.
}
