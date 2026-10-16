// AI-Generated
package module47_two_dimensional_arrays_ai.step04_neighbors_the_cells_around_a_cell_ai;

public class Challenge01Ai {
    /**
     * Make {@code countAround} work for every cell of the field, at the edges and in the corners too: a place outside the field has no mine. Check the indexes in the loops, or write a method like {@code hasMine} and call it. The check runs:
     * <pre>{@code
     * boolean[][] mines = {
     *     {true, false, false, false},
     *     {false, false, true, false},
     *     {true, true, false, false}
     * };
     * System.out.println(countAround(mines, 0, 3));
     * System.out.println(countAround(mines, 1, 1));
     * System.out.println(countAround(mines, 2, 2));
     * System.out.println(countAround(mines, 0, 0));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1
     * 4
     * 2
     * 0
     * }</pre>
     * Hints
     * 1. Read {@code mines[r][c]} only when {@code r} is from 0 to {@code mines.length - 1} and {@code c} from 0 to {@code mines[r].length - 1}.
     * 2. Put the checks in front of the cell in one condition: {@code r >= 0 && r < mines.length && c >= 0 && c < mines[r].length && mines[r][c]}. {@code &&} stops at the first false part, so a bad index is never used.
     */
    public static void main(String[] args) {
        boolean[][] mines = {
            {true, false, false, false},
            {false, false, true, false},
            {true, true, false, false}
        };
        System.out.println(countAround(mines, 0, 3));
        System.out.println(countAround(mines, 1, 1));
        System.out.println(countAround(mines, 2, 2));
        System.out.println(countAround(mines, 0, 0));
    }

    public static int countAround(boolean[][] mines, int row, int column) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r == row && c == column) {
                    continue;
                }
                if (mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}
