// AI-Generated
package module47_two_dimensional_arrays_ai.step06_four_in_a_row_and_the_end_of_part_12_ai.challenge03_ai;

public class Main {
    /**
     * To end part 12, the game needs a winner. Add a method {@code wins(char piece)} to {@code FourInARow}: it returns {@code true} when the board has four of that piece in a line, across, up and down, or diagonally in either direction, and {@code false} otherwise. {@code drop} is the one from the first task. {@code Main.java} is a test drive in which the players drop their pieces in turn, X first, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * .......
     * .......
     * ......X
     * .....XX
     * ....XXO
     * O..XOOO
     * X wins: true
     * O wins: false
     * }</pre>
     * Hints
     * 1. Try every cell as the start of a line, in four directions: across ({@code 0}, {@code 1}), down ({@code 1}, {@code 0}), down to the right ({@code 1}, {@code 1}) and down to the left ({@code 1}, {@code -1}). Going the other way would find the same lines again, from their other end.
     * 2. A helper method such as {@code fourFrom(row, column, rowStep, columnStep, piece)} can look at the cells {@code row + i * rowStep}, {@code column + i * columnStep} for {@code i} from 0 to 3, and return {@code false} as soon as one is outside the board or holds something else.
     */
    public static void main(String[] args) {
        FourInARow game = new FourInARow(6, 7);
        int[] moves = {3, 4, 4, 5, 5, 6, 5, 6, 6, 0, 6};
        char piece = 'X';
        for (int column : moves) {
            game.drop(column, piece);
            if (piece == 'X') {
                piece = 'O';
            } else {
                piece = 'X';
            }
        }
        System.out.println(game);
        System.out.println("X wins: " + game.wins('X'));
        System.out.println("O wins: " + game.wins('O'));
    }
}
