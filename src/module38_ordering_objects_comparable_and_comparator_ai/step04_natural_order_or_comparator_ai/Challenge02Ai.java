// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step04_natural_order_or_comparator_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Challenge02Ai {
    /**
     * A tree nursery sorts the names on its labels in several orders. A String's natural order is alphabetical. What does this program print?
     * Hints
     * 1. The second sort compares only the lengths, so elm and oak tie, and so do birch and maple. A tie keeps the order the list had, and after the first sort that was alphabetical.
     * 2. {@code Comparator.reverseOrder()} is the natural order backwards: Z to A, whatever order the list was in before.
     */
    public static void main(String[] args) {
        List<String> trees = new ArrayList<>();
        trees.add("maple");
        trees.add("oak");
        trees.add("willow");
        trees.add("birch");
        trees.add("elm");
        Collections.sort(trees);
        System.out.println(trees);
        trees.sort(Comparator.comparing(String::length));
        System.out.println(trees);
        trees.sort(Comparator.reverseOrder());
        System.out.println(trees);
    }
}
