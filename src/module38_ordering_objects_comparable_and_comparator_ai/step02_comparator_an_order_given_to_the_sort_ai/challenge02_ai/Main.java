// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step02_comparator_an_order_given_to_the_sort_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    /**
     * A ski resort's app shows its slopes in different orders. Each slope has a name and the centimeters of fresh snow on it. What does this program print?
     * Hints
     * 1. The first sort puts the most snow first. Glacier and Eagle both have 25: {@code reversed()} turns the comparator's answers around, but a tie is still a tie, so they keep the list's order, Glacier first.
     * 2. {@code byName} sorts from A to Z: Eagle, Glacier, Pine, Summit. {@code byName.reversed()} sorts from Z to A.
     */
    public static void main(String[] args) {
        List<Slope> slopes = new ArrayList<>();
        slopes.add(new Slope("Summit", 8));
        slopes.add(new Slope("Glacier", 25));
        slopes.add(new Slope("Pine", 0));
        slopes.add(new Slope("Eagle", 25));

        slopes.sort(Comparator.comparing(Slope::getSnow).reversed());
        System.out.println(slopes.get(0) + " " + slopes.get(1));

        Comparator<Slope> byName = Comparator.comparing(Slope::getName);
        Collections.sort(slopes, byName);
        System.out.println(slopes.get(0) + " " + slopes.get(3));

        slopes.sort(byName.reversed());
        System.out.println(slopes.get(0));
    }
}
