// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step05_lists_as_parameters_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * Write a method {@code printNumbered(ArrayList<String> items)} that prints the items one per line, each with its number in front: {@code 1. } for the first, {@code 2. } for the second, and so on. The check builds a list of {@code oats}, {@code pears} and {@code honey}, and calls {@code printNumbered(items);}: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1. oats
     * 2. pears
     * 3. honey
     * }</pre>
     * Hints
     * 1. The method is {@code void}: <code>public static void printNumbered(ArrayList&lt;String&gt; items) {</code>.
     * 2. The number is the index plus one, so an index loop fits: {@code (i + 1) + ". " + items.get(i)}.
     */
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("oats");
        items.add("pears");
        items.add("honey");
        printNumbered(items);
    }

    // Write the printNumbered method here.
}
