// AI-Generated
package module47_two_dimensional_arrays_ai.step04_neighbors_the_cells_around_a_cell_ai;

public class Challenge02Ai {
    /**
     * Now the whole field, as the game shows it at the end. Write a method {@code printField(boolean[][] mines)} that prints the field one row per line: {@code *} for a mine, and for every other square the number of mines around it, with nothing between the squares. {@code countAround} is ready, with the check of the indexes. For the field of this step, the check prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * *211
     * 34*1
     * **21
     * }</pre>
     * Hints
     * 1. The method starts <code>public static void printField(boolean[][] mines) {</code>. Go through the cells with a loop over the rows and, inside it, a loop over the columns of that row.
     * 2. In each cell, {@code print} either {@code "*"} or {@code countAround(mines, row, column)}. After the inner loop, {@code println()} ends the row.
     */
    public static void main(String[] args) {
        boolean[][] mines = {
            {true, false, false, false},
            {false, false, true, false},
            {true, true, false, false}
        };
        printField(mines);
    }

    // Write the printField method here.

    public static int countAround(boolean[][] mines, int row, int column) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r == row && c == column) {
                    continue;
                }
                if (r >= 0 && r < mines.length && c >= 0 && c < mines[r].length && mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}
