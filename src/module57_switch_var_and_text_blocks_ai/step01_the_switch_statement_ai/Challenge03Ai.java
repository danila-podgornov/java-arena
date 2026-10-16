// AI-Generated
package module57_switch_var_and_text_blocks_ai.step01_the_switch_statement_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The pill organizer's reminder now only needs to know the kind of day. Read a day's number (1 is Monday, 7 is Sunday), a whole number on one line, and print {@code weekday} for 1 to 5, {@code weekend} for 6 and 7, and {@code No such day} for any other number. Use a switch where several labels share one branch, so that the program has only three {@code println} lines. With the input {@code 6}, the program prints: see the expected output below.
     * Expected output
     * {@code weekend}
     * Hints
     * 1. Labels in a row share the statements after the last of them: {@code case 6:} followed straight by {@code case 7:}. Or put the values on one line: {@code case 6, 7:}.
     * 2. Days 1 to 5 are one label line too: {@code case 1, 2, 3, 4, 5:}. Then {@code default:} for everything else.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = Integer.valueOf(scanner.nextLine());

    }
}
