// AI-Generated
package module47_two_dimensional_arrays_ai.step05_rows_of_different_lengths_and_grids_of_objects_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * What does this program print? Keep in mind which places of the outer array lead to the same row.
     * Hints
     * 1. {@code grid[2] = grid[1];} makes row 2 and row 1 the same array, so {@code grid[2][0] = 9} changes {@code grid[1][0]} too. Row 0 is a new array of two ints, both 0.
     * 2. The outer array has 3 places, and row 2 is the row {@code {4, 5, 6}} (now starting with 9), which has 3 elements.
     */
    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[2];
        grid[1] = new int[] {4, 5, 6};
        grid[2] = grid[1];
        grid[2][0] = 9;
        System.out.println(grid[1][0] + " " + grid[0][1]);
        System.out.println(grid.length + " " + grid[2].length);
        System.out.println(Arrays.deepToString(grid));
    }
}
