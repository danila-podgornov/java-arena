// AI-Generated
package module47_two_dimensional_arrays_ai.step02_going_through_a_grid_ai;

public class Challenge01Ai {
    /**
     * The program draws a picture from its brightness values, one line per row: {@code #} for a pixel of 5 or more, and {@code .} for the others. Fill in the blanks, so the loops go through every row, and through every column of each row. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * ..#..
     * .###.
     * #####
     * ..#..
     * }</pre>
     * Hints
     * 1. The outer loop goes through the rows, and the number of rows is the length of the outer array: {@code image.length}.
     * 2. The inner loop goes through the columns of row {@code row}, so it stops at the length of that row: {@code image[row].length}.
     */
    public static void main(String[] args) {
        int[][] image = {
            {1, 2, 7, 2, 0},
            {0, 6, 8, 5, 1},
            {5, 9, 9, 7, 6},
            {0, 3, 8, 2, 1}
        };
        for (int row = 0; row < ___; row++) {
            for (int column = 0; column < ___; column++) {
                if (image[row][column] >= 5) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
