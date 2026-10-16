// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step03_taking_text_apart_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The program reads one line of chess moves, separated by spaces, and prints how many moves there are, how many of them capture a piece (they contain an {@code x}), and how many give check (they end with {@code +}). Fill in the blanks. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Moves: 12
     * Captures: 3
     * Checks: 1
     * }</pre>
     * Hints
     * 1. {@code split(" ")} cuts the line at every space, into an array of moves. An array's size is its {@code length}, without parentheses.
     * 2. {@code contains} asks whether a piece of text appears anywhere in the move, and {@code endsWith} whether the move ends with it.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = scanner.nextLine().___(" ");
        int captures = 0;
        int checks = 0;
        for (String move : moves) {
            if (move.___("x")) {
                captures++;
            }
            if (move.___("+")) {
                checks++;
            }
        }
        System.out.println("Moves: " + ___);
        System.out.println("Captures: " + captures);
        System.out.println("Checks: " + checks);
    }
}
