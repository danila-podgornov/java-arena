// AI-Generated
package module47_two_dimensional_arrays_ai.step04_neighbors_the_cells_around_a_cell_ai;

public class Challenge03Ai {
    /**
     * A hiking map gives the height of the ground in each square, in meters. A square is a <b>hilltop</b> when it's higher than each of its neighbors above, below, to the left and to the right. The diagonal squares don't count here, and a square on the edge simply has fewer neighbors. Write a method {@code printHilltops(int[][] heights)} that prints every hilltop, row by row from the top and from left to right in each row, like {@code Row 1, column 1: 140 m} (rows and columns counted from 0), and then the number of hilltops. The check passes this map:
     * <pre>{@code
     * int[][] heights = {
     *     {120, 135, 130, 110},
     *     {125, 140, 128, 132},
     *     {118, 122, 126, 121}
     * };
     * printHilltops(heights);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Row 1, column 1: 140 m
     * Row 1, column 3: 132 m
     * Hilltops: 2
     * }</pre>
     * Hints
     * 1. Go through every square. For each one, start from {@code boolean hilltop = true;} and look at the four neighbors, with the step arrays of this step or with four separate checks.
     * 2. A neighbor that's inside the map and at least as high ({@code >=}) as the square means it's not a hilltop. After the four neighbors, print the square if it's still a hilltop, and count it.
     */
    public static void main(String[] args) {
        int[][] heights = {
            {120, 135, 130, 110},
            {125, 140, 128, 132},
            {118, 122, 126, 121}
        };
        printHilltops(heights);
    }

    // Write the printHilltops method here.
}
