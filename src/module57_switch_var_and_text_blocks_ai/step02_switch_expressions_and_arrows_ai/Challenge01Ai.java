// AI-Generated
package module57_switch_var_and_text_blocks_ai.step02_switch_expressions_and_arrows_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A shopping mall's directory sign shows what is on each level. The program reads a floor's number, a whole number on one line, and prints its place, with a chain of {@code if} and {@code else if}. Rewrite it so that a switch expression with arrows gives the place, and the program prints it. Keep what it prints the same: {@code Parking} for -1, {@code Lobby} for 0, {@code Shops} for 1, {@code Food court} for 2, and {@code Offices} for any other floor. With the input {@code 2}, the program prints: see the expected output below.
     * Expected output
     * {@code Food court}
     * Hints
     * 1. Start with <code>String place = switch (floor) {</code> and give each floor a line such as {@code case 0 -> "Lobby";}.
     * 2. The {@code else} becomes {@code default -> "Offices";}. Remember the semicolon after the switch's closing brace: the whole switch is the value of {@code place}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floor = Integer.valueOf(scanner.nextLine());
        String place;
        if (floor == -1) {
            place = "Parking";
        } else if (floor == 0) {
            place = "Lobby";
        } else if (floor == 1) {
            place = "Shops";
        } else if (floor == 2) {
            place = "Food court";
        } else {
            place = "Offices";
        }
        System.out.println(place);
    }
}
