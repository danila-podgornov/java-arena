// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step06_enums_with_fields_a_constructor_and_methods_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * The café's cup sizes, with a method that gives the next size up. What does this program print?
     * Hints
     * 1. {@code larger()} returns the constant after this one, or this one when there's none after it. SMALL's next is MEDIUM, which costs 4.
     * 2. From MEDIUM, two calls give LARGE and then LARGE again, since there's nothing larger. {@code Collections.sort} uses the natural order, the order in which the constants are written.
     */
    public static void main(String[] args) {
        CupSize cup = CupSize.SMALL;
        cup = cup.larger();
        System.out.println(cup + " " + cup.getPrice());
        cup = cup.larger().larger();
        System.out.println(cup.name() + " " + (cup == CupSize.LARGE));

        ArrayList<CupSize> sizes = new ArrayList<>();
        sizes.add(CupSize.LARGE);
        sizes.add(CupSize.SMALL);
        sizes.add(CupSize.MEDIUM);
        Collections.sort(sizes);
        System.out.println(sizes);
    }
}
