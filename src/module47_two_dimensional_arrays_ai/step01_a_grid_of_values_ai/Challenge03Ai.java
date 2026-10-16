// AI-Generated
package module47_two_dimensional_arrays_ai.step01_a_grid_of_values_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A cinema's room has 5 rows of 8 seats. Write its booking program. It reads bookings, one per line, until the line {@code end}. A booking is a row and a seat, counted from 1 as people count them, with a space between them, such as {@code 3 4}. Every row is 1 to 5 and every seat 1 to 8. Keep track of the booked seats in a {@code boolean[][]}:
     * <ul>
     * <li>a free seat gets booked, and the program prints {@code Booked row 3, seat 4}
     * <li>a seat that's already booked stays as it is, and the program prints {@code Row 3, seat 4 is taken}
     * </ul>
     * <p>At the end, it prints how many seats were booked. For the input {@code 3 4}, {@code 1 1}, {@code 3 4}, {@code 5 8} and {@code end} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Booked row 3, seat 4
     * Booked row 1, seat 1
     * Row 3, seat 4 is taken
     * Booked row 5, seat 8
     * Seats booked: 3
     * }</pre>
     * Hints
     * 1. Create the map with {@code new boolean[5][8]}. For each line, {@code split(" ")} gives the row and the seat as text, and {@code Integer.valueOf} turns each into a number.
     * 2. Row {@code row}, seat {@code seat} as people count is {@code booked[row - 1][seat - 1]}. If it's {@code true}, the seat is taken; otherwise set it to {@code true} and add one to a counter.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
