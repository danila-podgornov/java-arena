// AI-Generated
package module37_streams_and_lambdas_ai.step03_ending_a_stream_count_sum_average_collect_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge03Ai {
    /**
     * Write the method {@code bigExpenses(List<Integer> expenses, int limit)}, which returns a new list of the expenses of at least {@code limit} dollars, in the same order. Use a stream that ends with {@code collect(Collectors.toList())}. The import for Collectors is there already. The check runs:
     * <pre>{@code
     * List<Integer> expenses = new ArrayList<>();
     * expenses.add(54);
     * expenses.add(120);
     * expenses.add(18);
     * expenses.add(64);
     * System.out.println(bigExpenses(expenses, 60));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [120, 64]}
     * Hints
     * 1. The header is {@code public static List<Integer> bigExpenses(List<Integer> expenses, int limit)}. The method can return the stream's result straight away.
     * 2. {@code return expenses.stream().filter(amount -> amount >= limit).collect(Collectors.toList());}
     */
    public static void main(String[] args) {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(54);
        expenses.add(120);
        expenses.add(18);
        expenses.add(64);
        System.out.println(bigExpenses(expenses, 60));
    }

    // Write the method bigExpenses here.
}
