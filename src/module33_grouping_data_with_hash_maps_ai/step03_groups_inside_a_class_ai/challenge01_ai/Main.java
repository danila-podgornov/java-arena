// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step03_groups_inside_a_class_ai.challenge01_ai;

public class Main {
    /**
     * A restaurant keeps the dishes that each table has ordered. Tables have numbers, so the keys are {@code Integer}s: {@code HashMap<Integer, ArrayList<String>>}. In {@code TableOrders.java}, write:
     * <ul>
     * <li>the constructor, which creates the map,
     * <li>{@code add(int table, String dish)}, which adds the dish to the table's list, and creates the list for the table's first dish,
     * <li>{@code dishesAt(int table)}, which returns the table's list of dishes, or an empty list for a table with no orders,
     * <li>{@code tables()}, which returns a new list of the table numbers that have orders, from the smallest to the largest.
     * </ul>
     * <p>{@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [3, 12, 21]
     * [soup, salad]
     * []
     * }</pre>
     * Hints
     * 1. The constructor is one line: {@code this.orders = new HashMap<>();}. {@code add} and {@code dishesAt} are ClubRegister's {@code join} and {@code members}, with an {@code int} table as the key. Java turns the {@code int} into an {@code Integer} key by itself.
     * 2. For {@code tables()}, copy the keys into a new list, {@code new ArrayList<>(this.orders.keySet())}, sort it with {@code Collections.sort}, and return it. Integers sort by their value, so 3 comes before 12.
     */
    public static void main(String[] args) {
        TableOrders orders = new TableOrders();
        orders.add(12, "soup");
        orders.add(3, "curry");
        orders.add(12, "salad");
        orders.add(21, "tea");
        System.out.println(orders.tables());
        System.out.println(orders.dishesAt(12));
        System.out.println(orders.dishesAt(5));
    }
}
