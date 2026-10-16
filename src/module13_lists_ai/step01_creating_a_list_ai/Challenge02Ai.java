// AI-Generated
package module13_lists_ai.step01_creating_a_list_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print? Type each line.
     * Hints
     * 1. A new list is empty, and an empty list prints as {@code []}.
     * 2. {@code add} always puts the value at the end, even when the list already holds it: the last line shows {@code Ana} twice.
     */
    public static void main(String[] args) {
        ArrayList<String> queue = new ArrayList<>();
        System.out.println(queue);
        queue.add("Ana");
        queue.add("Ben");
        System.out.println(queue);
        queue.add("Ana");
        System.out.println("Queue: " + queue);
    }
}
