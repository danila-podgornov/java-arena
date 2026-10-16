// AI-Generated
package module47_two_dimensional_arrays_ai.step03_rows_columns_and_totals_ai;

public class Challenge01Ai {
    /**
     * Here's another year's table. Fill in the blanks, so the program prints the store that sold the most mattresses in each month. The outer loop goes through the months (the columns), and the inner one compares each store (a row) with the best one so far. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Jan: Riverside
     * Feb: Station
     * Mar: Market
     * Apr: Riverside
     * }</pre>
     * Hints
     * 1. The outer loop goes through the columns, and the number of columns is the length of a row: {@code sales[0].length}.
     * 2. Each store's sale for the month is compared with the best store's sale for the same month, which is in the row {@code bestRow}.
     */
    public static void main(String[] args) {
        String[] stores = {"Riverside", "Station", "Market"};
        String[] months = {"Jan", "Feb", "Mar", "Apr"};
        int[][] sales = {
            {14, 15, 9, 21},
            {8, 17, 14, 10},
            {12, 16, 22, 19}
        };
        for (int column = 0; column < ___; column++) {
            int bestRow = 0;
            for (int row = 1; row < sales.length; row++) {
                if (sales[row][column] > sales[___][column]) {
                    bestRow = row;
                }
            }
            System.out.println(months[column] + ": " + stores[bestRow]);
        }
    }
}
