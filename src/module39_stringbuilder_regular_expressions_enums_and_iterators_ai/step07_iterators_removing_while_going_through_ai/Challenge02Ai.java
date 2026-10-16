// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step07_iterators_removing_while_going_through_ai;

import java.util.ArrayList;
import java.util.Iterator;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. The first loop goes through all five names, so {@code round} ends at 5. In rounds 2 and 4, {@code remove()} removes the name that {@code next()} returned in that round: Ben and Dee.
     * 2. The second iterator starts from the front of what's left, Ada, Cy and Eve. After two calls to {@code next()}, the last one returned is Cy, and that's the one {@code remove()} removes.
     */
    public static void main(String[] args) {
        ArrayList<String> queue = new ArrayList<>();
        queue.add("Ada");
        queue.add("Ben");
        queue.add("Cy");
        queue.add("Dee");
        queue.add("Eve");

        Iterator<String> iterator = queue.iterator();
        int round = 0;
        while (iterator.hasNext()) {
            iterator.next();
            round++;
            if (round % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(queue + " " + round);

        Iterator<String> again = queue.iterator();
        again.next();
        again.next();
        again.remove();
        System.out.println(queue);
    }
}
