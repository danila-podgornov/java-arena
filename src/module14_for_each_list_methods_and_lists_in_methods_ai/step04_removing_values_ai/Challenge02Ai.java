// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step04_removing_values_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print? Check each {@code remove}: is it given an index or a value?
     * Hints
     * 1. {@code numbers.remove(1)} gets an {@code int}, so it removes index 1: the 2.
     * 2. {@code Integer.valueOf(1)} removes the value 1. Then {@code remove(0)} is an index again, so it removes the first value, 4.
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(0);
        numbers.add(1);

        numbers.remove(1);
        System.out.println(numbers);
        numbers.remove(Integer.valueOf(1));
        System.out.println(numbers);
        numbers.remove(0);
        System.out.println(numbers);
    }
}
