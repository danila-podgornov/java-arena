// AI-Generated
package module57_switch_var_and_text_blocks_ai.step01_the_switch_statement_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * In the board game Ladder Race, a roll of the die decides what you do. The program reads a roll, a whole number on one line, and prints what it means. With a roll of 2 it should print {@code Pick a card}, but it prints two lines. Find the bug and fix it, keeping the switch. With the input {@code 2}, the program prints: see the expected output below.
     * Expected output
     * {@code Pick a card}
     * Hints
     * 1. Which line does it print after {@code Pick a card}? That's the first line of the next case: the program fell through into it.
     * 2. Every case needs a {@code break;} at its end. One of them doesn't have one.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roll = Integer.valueOf(scanner.nextLine());
        switch (roll) {
            case 1:
                System.out.println("Miss a turn");
                break;
            case 2:
                System.out.println("Pick a card");
            case 3:
                System.out.println("Move 3 squares");
                break;
            case 4:
                System.out.println("Swap places with the leader");
                break;
            case 5:
                System.out.println("Move 5 squares");
                break;
            case 6:
                System.out.println("Move 6 squares");
                System.out.println("Roll again");
                break;
            default:
                System.out.println("Not a roll of a die");
        }
    }
}
