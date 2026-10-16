// AI-Generated
package module47_two_dimensional_arrays_ai.step06_four_in_a_row_and_the_end_of_part_12_ai.challenge01_ai;

public class Main {
    /**
     * {@code FourInARow.java} has the board, its constructor, which fills the board with {@code '.'}, and {@code toString}, which shows the board one row per line. Write {@code drop(int column, char piece)}: it puts the piece in the lowest free place of the column and returns the row the piece landed in, or, when the column is full, changes nothing and returns -1. The check runs:
     * <pre>{@code
     * FourInARow game = new FourInARow(4, 5);
     * System.out.println(game.drop(1, 'X'));
     * System.out.println(game.drop(1, 'O'));
     * System.out.println(game.drop(3, 'X'));
     * System.out.println(game);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 2
     * 3
     * .....
     * .....
     * .O...
     * .X.X.
     * }</pre>
     * Hints
     * 1. Go up the column from the bottom row: {@code for (int row = this.board.length - 1; row >= 0; row--)}. The column stays the same all the way.
     * 2. At the first place that holds {@code '.'}, put the piece there and {@code return row;} at once. If the loop ends without finding one, the column is full: {@code return -1;}
     */
    public static void main(String[] args) {
        FourInARow game = new FourInARow(4, 5);
        System.out.println(game.drop(1, 'X'));
        System.out.println(game.drop(1, 'O'));
        System.out.println(game.drop(3, 'X'));
        System.out.println(game);
    }
}
