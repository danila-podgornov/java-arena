// AI-Generated
package module47_two_dimensional_arrays_ai.step03_rows_columns_and_totals_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * Write a method {@code rowTotals(int[][] grid)} that returns a new array with one element for each row of the grid: the total of that row. The check passes this year's mattress sales, the table from the start of this step, and prints what your method returns with {@code Arrays.toString}: see the expected output below.
     * Expected output
     * {@code [56, 43, 85]}
     * Hints
     * 1. The method starts <code>public static int[] rowTotals(int[][] grid) {</code>. The array it returns has one element per row: {@code new int[grid.length]}.
     * 2. Go through every cell, and add each value to the total of its own row: {@code totals[row] += grid[row][column];}
     */
    public static void main(String[] args) {
        int[][] sales = {
            {12, 15, 9, 20},
            {8, 11, 14, 10},
            {20, 18, 22, 25}
        };
        System.out.println(Arrays.toString(rowTotals(sales)));
    }

    // Write the rowTotals method here.
}
