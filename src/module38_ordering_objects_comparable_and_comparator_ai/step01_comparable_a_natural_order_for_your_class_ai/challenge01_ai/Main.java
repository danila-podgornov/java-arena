// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step01_comparable_a_natural_order_for_your_class_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * A rental site lists apartments, the cheapest first. {@code Apartment.java} has a street and a monthly rent. Make Apartment implement {@code Comparable<Apartment>}, with a {@code compareTo} that orders apartments by rent, the cheapest first. Use {@code Integer.compare}, and put {@code @Override} above the method. Compare only the rents: two apartments with the same rent are a tie, so {@code compareTo} gives 0 and the sort keeps them in the list's order. The check runs:
     * <pre>{@code
     * ArrayList<Apartment> listings = new ArrayList<>();
     * listings.add(new Apartment("12 Elm Street", 1450));
     * listings.add(new Apartment("3 Harbor Lane", 980));
     * listings.add(new Apartment("47 Hill Road", 1200));
     * Collections.sort(listings);
     * System.out.println(listings);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [3 Harbor Lane (980), 47 Hill Road (1200), 12 Elm Street (1450)]}
     * Hints
     * 1. Change the header to <code>public class Apartment implements Comparable&lt;Apartment&gt; {</code>. Then the class must have the method {@code public int compareTo(Apartment other)}.
     * 2. The cheapest comes first, so {@code this} goes before {@code other} when its rent is smaller: {@code return Integer.compare(this.rent, other.rent);}.
     */
    public static void main(String[] args) {
        ArrayList<Apartment> listings = new ArrayList<>();
        listings.add(new Apartment("12 Elm Street", 1450));
        listings.add(new Apartment("3 Harbor Lane", 980));
        listings.add(new Apartment("47 Hill Road", 1200));
        Collections.sort(listings);
        System.out.println(listings);
    }
}
