// AI-Generated
package module51_data_visualization_ai.step06_bar_charts_for_categories_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    /**
     * A stand at a farmers' market writes down each sale as a row, {@code apples,3}: the product and the kilograms (whole numbers). For a bar chart of the day, it needs the totals and the products in order. Write the class {@code SalesLog} in {@code SalesLog.java}, with two methods:
     * <ul>
     * <li>{@code public static Map<String, Integer> totals(List<String> rows)}: a map from each product to the sum of its kilograms
     * <li>{@code public static List<String> products(List<String> rows)}: each product once, in the order it first appears in the rows
     * </ul>
     * <p>The rows have no header. No JavaFX in it. The check runs:
     * <pre>{@code
     * List<String> rows = new ArrayList<>();
     * rows.add("apples,3");
     * rows.add("pears,2");
     * rows.add("apples,5");
     * rows.add("plums,1");
     * rows.add("pears,4");
     * System.out.println(SalesLog.products(rows));
     * Map<String, Integer> totals = SalesLog.totals(rows);
     * System.out.println(totals.get("apples") + " " + totals.get("pears") + " " + totals.get("plums"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [apples, pears, plums]
     * 8 6 1
     * }</pre>
     * Hints
     * 1. In {@code totals}, split each row and add its kilograms to the product's total: {@code totals.getOrDefault(product, 0)} gives 0 for a product not seen yet.
     * 2. In {@code products}, add a product to the list only when {@code products.contains(product)} is false, so each one is there once, in the order of its first row.
     */
    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        rows.add("apples,3");
        rows.add("pears,2");
        rows.add("apples,5");
        rows.add("plums,1");
        rows.add("pears,4");
        System.out.println(SalesLog.products(rows));
        Map<String, Integer> totals = SalesLog.totals(rows);
        System.out.println(totals.get("apples") + " " + totals.get("pears") + " " + totals.get("plums"));
    }
}
