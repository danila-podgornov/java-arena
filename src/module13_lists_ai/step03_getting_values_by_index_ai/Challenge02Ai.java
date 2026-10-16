// AI-Generated
package module13_lists_ai.step03_getting_values_by_index_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print? Watch the index calculations, and the {@code +} signs in the last line.
     * Hints
     * 1. Index 1 holds 9 and index 2 holds 2. Two numbers added together give a number: 4 + 2 is 6.
     * 2. In the last line the text comes first, so each {@code +} joins text: {@code Sum: }, then {@code 4}, then {@code 2}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(9);
        numbers.add(2);
        int i = 1;
        System.out.println(numbers.get(i));
        System.out.println(numbers.get(i + 1));
        System.out.println(numbers.get(0) + numbers.get(2));
        System.out.println("Sum: " + numbers.get(0) + numbers.get(2));
    }
}
