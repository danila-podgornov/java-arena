// AI-Generated
package module47_two_dimensional_arrays_ai.step05_rows_of_different_lengths_and_grids_of_objects_ai;

import java.util.Arrays;

public class Challenge01Ai {
    /**
     * An outdoor theater's rows get longer toward the back: the front row has 4 seats, and each row has one seat more than the row in front of it. Fill in the blanks: create the outer array for 3 rows, with the length of the rows left out, give each row its length, and print the whole grid. The program prints: see the expected output below.
     * Expected output
     * {@code [[1, 2, 3, 4], [1, 2, 3, 4, 5], [1, 2, 3, 4, 5, 6]]}
     * Hints
     * 1. The outer array has a place for each of the 3 rows: {@code new int[3][]}. Row 0 has 4 seats, row 1 has 5, so row {@code row} has {@code row + 4}.
     * 2. The method of {@code Arrays} that prints the values inside the rows too is {@code deepToString}.
     */
    public static void main(String[] args) {
        int[][] seats = new int[___][];
        for (int row = 0; row < seats.length; row++) {
            seats[row] = new int[___];
            for (int seat = 0; seat < seats[row].length; seat++) {
                seats[row][seat] = seat + 1;
            }
        }
        System.out.println(Arrays.___(seats));
    }
}
