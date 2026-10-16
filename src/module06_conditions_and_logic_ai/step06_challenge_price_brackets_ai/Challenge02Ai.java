// AI-Generated
package module06_conditions_and_logic_ai.step06_challenge_price_brackets_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A delivery service charges by distance (an invented price list):
     * <table>
     * <tr><th>Distance</th><th>Price</th></tr>
     * <tr><td>up to 5 km</td><td>3.0 euros</td></tr>
     * <tr><td>over 5 km, up to 20 km</td><td>3.0 plus 0.5 for every km over 5</td></tr>
     * <tr><td>over 20 km</td><td>10.5 plus 1.0 for every km over 20</td></tr>
     * </table>
     * <p>Read the distance in whole kilometres and print the price. For the input {@code 12} the program prints: see the expected output below.
     * Expected output
     * {@code Price: 6.5 euros}
     * Hints
     * 1. The km over 5 is {@code km - 5}, so the middle bracket is {@code 3.0 + 0.5 * (km - 5)}.
     * 2. 10.5 is what exactly 20 km costs (3.0 + 0.5 * 15), so the last bracket continues from there.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int km = Integer.valueOf(scanner.nextLine());

    }
}
