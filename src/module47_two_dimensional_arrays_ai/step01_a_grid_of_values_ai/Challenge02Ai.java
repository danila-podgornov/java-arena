// AI-Generated
package module47_two_dimensional_arrays_ai.step01_a_grid_of_values_ai;

public class Challenge02Ai {
    /**
     * A garden has two tomato beds, and {@code picked[bed][week]} holds how many tomatoes were picked from a bed in each of three weeks. What does this program print? Keep the row and the column of each cell apart, and remember the default value.
     * Hints
     * 1. {@code picked[0][2]} is row 0, column 2: bed 0's third week. It gets bed 1's third week plus one, so 4.
     * 2. {@code picked[1][0]++} adds one to a cell that held the default 0. The cells that are never assigned, such as {@code picked[0][1]}, stay 0.
     */
    public static void main(String[] args) {
        int[][] picked = new int[2][3];
        picked[0][0] = 2;
        picked[1][2] = 3;
        picked[0][2] = picked[1][2] + 1;
        picked[1][0]++;
        System.out.println(picked[0][0] + picked[0][1] + picked[0][2]);
        System.out.println(picked[1][0] + picked[1][1] + picked[1][2]);
        System.out.println(picked[0][1]);
    }
}
