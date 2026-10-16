// AI-Generated
package module47_two_dimensional_arrays_ai.step06_four_in_a_row_and_the_end_of_part_12_ai.challenge03_ai;

public class FourInARow {
    private char[][] board;

    public FourInARow(int rows, int columns) {
        this.board = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                this.board[row][column] = '.';
            }
        }
    }

    public int drop(int column, char piece) {
        for (int row = this.board.length - 1; row >= 0; row--) {
            if (this.board[row][column] == '.') {
                this.board[row][column] = piece;
                return row;
            }
        }
        return -1;
    }

    public boolean wins(char piece) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int row = 0; row < this.board.length; row++) {
            if (row > 0) {
                text.append("\n");
            }
            for (int column = 0; column < this.board[row].length; column++) {
                text.append(this.board[row][column]);
            }
        }
        return text.toString();
    }
}
