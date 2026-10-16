// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step01_comparable_a_natural_order_for_your_class_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * A spice rack is easier to use in alphabetical order. {@code Spice.java} has a name and the grams left. Write:
     * <ul>
     * <li>in {@code Spice.java}: make Spice implement {@code Comparable<Spice>}, with a {@code compareTo} that orders spices by name, alphabetically. Compare only the names: two spices with the same name are a tie, so {@code compareTo} gives 0 and they keep the list's order.
     * <li>in {@code Main.java}: the method {@code printRack(List<Spice> rack)}, which prints the spices one per line in alphabetical order, without changing the list. Use a stream with {@code sorted()}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * List<Spice> rack = new ArrayList<>();
     * rack.add(new Spice("Paprika", 50));
     * rack.add(new Spice("Cumin", 40));
     * rack.add(new Spice("Saffron", 2));
     * rack.add(new Spice("Cardamom", 25));
     * printRack(rack);
     * System.out.println(rack.get(0));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Cardamom (25 g)
     * Cumin (40 g)
     * Paprika (50 g)
     * Saffron (2 g)
     * Paprika (50 g)
     * }</pre>
     * Hints
     * 1. The header becomes <code>public class Spice implements Comparable&lt;Spice&gt; {</code>. A String already knows alphabetical order, so Spice's {@code compareTo} can hand the job to the names' own {@code compareTo}, as the talks did with their titles.
     * 2. {@code compareTo} is one line, {@code return this.name.compareTo(other.name);}. {@code printRack} is {@code public static void printRack(List<Spice> rack)}, and its body is one stream: {@code rack.stream().sorted().forEach(System.out::println);}. {@code sorted()} uses Spice's {@code compareTo}.
     */
    public static void main(String[] args) {
        List<Spice> rack = new ArrayList<>();
        rack.add(new Spice("Paprika", 50));
        rack.add(new Spice("Cumin", 40));
        rack.add(new Spice("Saffron", 2));
        rack.add(new Spice("Cardamom", 25));
        printRack(rack);
        System.out.println(rack.get(0));
    }

    // Write the method printRack here.
}
