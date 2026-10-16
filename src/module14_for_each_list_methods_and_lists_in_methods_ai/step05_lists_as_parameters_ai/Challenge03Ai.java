// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step05_lists_as_parameters_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * Write a method {@code onlyEven(ArrayList<Integer> numbers)} that returns a new list with just the even values of {@code numbers}, in the same order. The original list stays as it was. The check builds a list of 4, 7, 12 and 9, and prints what {@code onlyEven} returns: see the expected output below.
     * Expected output
     * {@code [4, 12]}
     * Hints
     * 1. The return type is a list: <code>public static ArrayList&lt;Integer&gt; onlyEven(ArrayList&lt;Integer&gt; numbers) {</code>.
     * 2. Make a new empty list, add each number where {@code number % 2 == 0}, and return the new list.
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(7);
        numbers.add(12);
        numbers.add(9);
        System.out.println(onlyEven(numbers));
    }

    // Write the onlyEven method here.
}
