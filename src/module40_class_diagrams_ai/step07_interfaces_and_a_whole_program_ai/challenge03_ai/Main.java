// AI-Generated
package module40_class_diagrams_ai.step07_interfaces_and_a_whole_program_ai.challenge03_ai;

public class Main {
    /**
     * To close the module, a whole program from one diagram. A board-game café bills each visit for table time and drinks. Write the four parts of this diagram, each in its own file:
     * <pre>{@code
     * interface Billable
     * + price(): int
     *
     * class TableTime implements Billable
     * - hours: int
     * - players: int
     * + TableTime(hours: int, players: int)
     * + price(): int
     *
     * class Drink implements Billable
     * - name: String
     * - large: boolean
     * + Drink(name: String, large: boolean)
     * + price(): int
     *
     * class Visit
     * - guest: String
     * + Visit(guest: String)
     * + add(item: Billable): void
     * + total(): int
     * + toString(): String
     *
     * Visit --> * Billable : items
     * }</pre>
     * <ul>
     * <li>Table time costs 3 dollars per player per hour.
     * <li>A drink costs 4 dollars, or 6 if it's large.
     * <li>A new visit has nothing on its bill. {@code add} puts an item on it, and {@code total} returns the prices of the visit's items added up.
     * <li>A visit's {@code toString} returns {@code Visit of Ana: 3 items, 34 dollars}, with the visit's own guest, number of items and total.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Visit visit = new Visit("Ana");
     * visit.add(new TableTime(2, 4));
     * visit.add(new Drink("cocoa", true));
     * visit.add(new Drink("tea", false));
     * System.out.println(visit);
     * System.out.println(new TableTime(1, 3).price());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Visit of Ana: 3 items, 34 dollars
     * 9
     * }</pre>
     * Hints
     * 1. Write the files in the order of the lesson: Billable first (one method header), then TableTime and Drink, which implement it (the dashed triangles), and Visit last. Visit's arrow with a star is {@code private ArrayList<Billable> items;}.
     * 2. Visit's {@code total} adds up {@code price()} over its list, and each item runs its own class's {@code price}. {@code toString} uses the list's size and {@code total()}.
     */
    public static void main(String[] args) {
        Visit visit = new Visit("Ana");
        visit.add(new TableTime(2, 4));
        visit.add(new Drink("cocoa", true));
        visit.add(new Drink("tea", false));
        System.out.println(visit);
        System.out.println(new TableTime(1, 3).price());
    }
}
