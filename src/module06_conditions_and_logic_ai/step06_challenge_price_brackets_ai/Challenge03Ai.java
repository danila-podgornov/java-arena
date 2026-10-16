// AI-Generated
package module06_conditions_and_logic_ai.step06_challenge_price_brackets_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A library's late fee (an invented table), for a book returned some whole number of days late:
     * <table>
     * <tr><th>Days late</th><th>Fee</th></tr>
     * <tr><td>0</td><td>nothing</td></tr>
     * <tr><td>1 to 7</td><td>1 euro per day</td></tr>
     * <tr><td>8 to 14</td><td>7 euros plus 2 per day over 7</td></tr>
     * <tr><td>15 to 30</td><td>21 euros plus 3 per day over 14</td></tr>
     * <tr><td>over 30</td><td>70 euros</td></tr>
     * </table>
     * <p>Read the number of days and print {@code Nothing to pay} or {@code Fee: N euros}. For the input {@code 10} the program prints: see the expected output below.
     * Expected output
     * {@code Fee: 13 euros}
     * Hints
     * 1. Handle 0 first with its own message, then the four fee brackets from the smallest up.
     * 2. In the 8 to 14 bracket, the days over 7 are {@code days - 7}: 10 days is 7 + 2 * 3 = 13.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.valueOf(scanner.nextLine());

    }
}
