// AI-Generated
package module47_two_dimensional_arrays_ai.step02_going_through_a_grid_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Work out what the first loops put in each cell, and how many times the inner one of the last loops runs for each row.
     * Hints
     * 1. Each cell gets its row times 10 plus its column, so {@code grid[2][1]} is 21. {@code grid.length} counts the rows, and {@code grid[0].length} the columns of row 0.
     * 2. In the last loops, the column starts from the row number: row 0 counts columns 0 to 3, row 1 columns 1 to 3, and row 2 columns 2 and 3.
     */
    public static void main(String[] args) {
        int[][] grid = new int[3][4];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = row * 10 + column;
            }
        }
        System.out.println(grid[2][1] + " " + grid[1][3]);
        System.out.println(grid.length + " " + grid[0].length);
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = row; column < grid[row].length; column++) {
                count++;
            }
        }
        System.out.println(count);
    }
}
