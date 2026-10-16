// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step07_the_list_toolbox_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so an urgent case goes to the front of the waiting list, and the program then empties the list and checks that it's empty. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Urgent case, Lotta, Sven]
     * Nobody is waiting
     * }</pre>
     * Hints
     * 1. The front of the list is index 0, and {@code add(index, value)} takes the index first.
     * 2. {@code clear()} removes every value, and {@code isEmpty()} tells whether any are left.
     */
    public static void main(String[] args) {
        ArrayList<String> waiting = new ArrayList<>();
        waiting.add("Lotta");
        waiting.add("Sven");
        waiting.add(___, "Urgent case");
        System.out.println(waiting);

        waiting.___();
        if (waiting.___()) {
            System.out.println("Nobody is waiting");
        }
    }
}
