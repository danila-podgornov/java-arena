// AI-Generated
package module47_two_dimensional_arrays_ai.step02_going_through_a_grid_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * A photo app can flip a picture from left to right, as a mirror does. Write a method {@code mirrored(int[][] image)} that returns a <b>new</b> grid of the same size, where each row holds the values of the same row of {@code image}, in the reverse order. The grid it's given must stay as it was. The check passes this grid:
     * <pre>{@code
     * int[][] image = {
     *     {1, 2, 3},
     *     {4, 5, 6}
     * };
     * }</pre>
     * <p>and prints each row of the grid your method returns with {@code Arrays.toString}: see the expected output below.
     * Expected output
     * <pre>{@code
     * [3, 2, 1]
     * [6, 5, 4]
     * }</pre>
     * Hints
     * 1. The method starts <code>public static int[][] mirrored(int[][] image) {</code> and creates the new grid with {@code new int[image.length][image[0].length]}.
     * 2. In row {@code row}, the value for column {@code column} comes from the other end of the same row: {@code image[row][image[row].length - 1 - column]}.
     */
    public static void main(String[] args) {
        int[][] image = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] flipped = mirrored(image);
        for (int[] row : flipped) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Write the mirrored method here.
}
