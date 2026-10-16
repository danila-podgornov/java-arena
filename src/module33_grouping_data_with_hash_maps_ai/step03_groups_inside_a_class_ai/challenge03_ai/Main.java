// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step03_groups_inside_a_class_ai.challenge03_ai;

public class Main {
    /**
     * The restaurant needs two more methods in {@code TableOrders}. The class from the first task is ready. Add:
     * <ul>
     * <li>{@code countOf(String dish)}, which returns how many of that dish have been ordered at all the tables together.
     * <li>{@code tablesWith(String dish)}, which returns a new list of the tables that have ordered the dish, from the smallest number to the largest. A table that ordered the dish more than once is on the list once.
     * </ul>
     * <p>{@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 4
     * [3, 12, 21]
     * [3] []
     * }</pre>
     * Hints
     * 1. {@code countOf} has to look at every table. Go through the lists with {@code for (ArrayList<String> dishes : this.orders.values())}, and count the dishes in each one that equal the one asked for. The order of the tables doesn't matter for a count.
     * 2. For {@code tablesWith}, go through {@code this.tables()}, which is already sorted, and add a table to a new list when its dishes {@code contains} the dish. Then each table is checked once, so it's on the list at most once, and the list comes out sorted.
     */
    public static void main(String[] args) {
        TableOrders orders = new TableOrders();
        orders.add(12, "soup");
        orders.add(3, "pie");
        orders.add(21, "soup");
        orders.add(3, "soup");
        orders.add(21, "soup");
        System.out.println(orders.countOf("soup"));
        System.out.println(orders.tablesWith("soup"));
        System.out.println(orders.tablesWith("pie") + " " + orders.tablesWith("tea"));
    }
}
