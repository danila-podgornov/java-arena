// AI-Generated
package module47_two_dimensional_arrays_ai.step03_rows_columns_and_totals_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The company wants a report from any sales table. The program reads the number of stores and the number of months on the first line, with a space between them. Then it reads one line per store, with that store's sales for each month, separated by spaces. It prints the total of the whole table, then the best store and the best month: the row and the column with the largest total, numbered from 1, each with its total. When two tie, the first one wins. For this step's table as input:
     * <pre>{@code
     * 3 4
     * 12 15 9 20
     * 8 11 14 10
     * 20 18 22 25
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Total: 184
     * Best store: 3 (85 mattresses)
     * Best month: 4 (55 mattresses)
     * }</pre>
     * Hints
     * 1. Read the sizes first, create {@code new int[stores][months]}, and fill it row by row: {@code split(" ")} each line, and put {@code Integer.valueOf(parts[column])} in {@code sales[row][column]}.
     * 2. Small methods help: {@code rowTotal(sales, row)} and {@code columnTotal(sales, column)}. Then the best store is a search over the rows with {@code >}, starting from row 0, and the best month the same search over the columns.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
