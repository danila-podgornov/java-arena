// AI-Generated
package module47_two_dimensional_arrays_ai.step06_four_in_a_row_and_the_end_of_part_12_ai;

public class Challenge02Ai {
    /**
     * What does this program print? {@code inLine} counts the cells in a line, from a starting cell, that hold the same piece as the starting cell.
     * Hints
     * 1. Each round of the loop counts one cell and then takes one step. It stops at the first cell that holds another piece, or at the edge of the board.
     * 2. The first call starts in the bottom left corner and goes up and to the right: rows 3, 2, 1, 0 and columns 0, 1, 2, 3. The last one goes down and to the left from row 1, column 3.
     */
    public static void main(String[] args) {
        char[][] board = {
            {'.', '.', '.', 'O'},
            {'X', '.', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
            {'O', 'X', 'X', 'O'}
        };
        System.out.println(inLine(board, 3, 0, -1, 1));
        System.out.println(inLine(board, 1, 0, 1, 0));
        System.out.println(inLine(board, 1, 3, 1, -1));
    }

    public static int inLine(char[][] board, int row, int column, int rowStep, int columnStep) {
        char piece = board[row][column];
        int count = 0;
        while (row >= 0 && row < board.length && column >= 0 && column < board[row].length && board[row][column] == piece) {
            count++;
            row += rowStep;
            column += columnStep;
        }
        return count;
    }
}
