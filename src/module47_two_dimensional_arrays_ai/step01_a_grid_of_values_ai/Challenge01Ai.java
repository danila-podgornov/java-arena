// AI-Generated
package module47_two_dimensional_arrays_ai.step01_a_grid_of_values_ai;

public class Challenge01Ai {
    /**
     * A cinema's smallest room has 4 rows of 6 seats. Two friends booked row 2, seats 3 and 4, as people count them. Fill in the blanks: create the seat map for exactly this room, and book the second friend's seat, next to the first one's. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Row 2, seat 3: true
     * Row 2, seat 4: true
     * Row 2, seat 5: false
     * Row 4, seat 6: false
     * }</pre>
     * Hints
     * 1. The first size is the number of rows and the second the number of seats in a row: {@code new boolean[4][6]}.
     * 2. Row 2, seat 4 as people count is index 1 for the row and index 3 for the seat, one less than each number.
     */
    public static void main(String[] args) {
        boolean[][] booked = new boolean[___][___];
        booked[1][2] = true;
        booked[1][___] = true;
        System.out.println("Row 2, seat 3: " + booked[1][2]);
        System.out.println("Row 2, seat 4: " + booked[1][3]);
        System.out.println("Row 2, seat 5: " + booked[1][4]);
        System.out.println("Row 4, seat 6: " + booked[3][5]);
    }
}
