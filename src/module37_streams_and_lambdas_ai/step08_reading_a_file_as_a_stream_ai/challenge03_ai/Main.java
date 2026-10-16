// AI-Generated
package module37_streams_and_lambdas_ai.step08_reading_a_file_as_a_stream_ai.challenge03_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     * {@code Expense.java} is ready. In {@code Main.java}, write the method {@code expensesIn(String file, String category)}, which reads a file of expenses in the form {@code category,amount} and returns the expenses of the given category as a {@code List<Expense>}, in the file's order. The category must match exactly: {@code groceries extra} is a category of its own, not {@code groceries}. The file may have empty lines: leave them out. If the file can't be read, the method prints {@code Error: } and the exception's message, and returns an empty list. Read the file with {@code Files.lines} and a stream, with no loops. The check runs, with the file {@code july.csv} shown below:
     * <pre>{@code
     * List<Expense> groceries = expensesIn("july.csv", "groceries");
     * System.out.println(groceries);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [groceries 54, groceries 38]}
     * Hints
     * 1. The header is {@code public static List<Expense> expensesIn(String file, String category)}. Start with an empty list, replace it with the collected one inside the {@code try} block, and return it after the {@code catch} block. A lambda can use the parameter {@code category}, as step 2 showed.
     * 2. Split each line first, and keep the arrays whose first part {@code equals(category)}: an empty line's only part is {@code ""}, so that drops the empty lines too. Then make an Expense of each array and {@code collect} them.
     */
    public static void main(String[] args) {
        List<Expense> groceries = expensesIn("july.csv", "groceries");
        System.out.println(groceries);
    }

    // Write the method expensesIn here.
}
