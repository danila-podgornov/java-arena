// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step03_taking_text_apart_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * At a chess tournament, the games are written down one per line: the player with the white pieces, the player with the black pieces, and the result, separated by commas, like {@code Mira,Jonas,1-0}. The result {@code 1-0} means that white won, {@code 0-1} that black won, and {@code 1/2-1/2} is a draw. A win is worth 1 point, a draw half a point, and a loss nothing.
     * <p>The first line of input is a player's name. Then come games, until an empty line. Print how many games that player played, and their points, which are a {@code double}. Skip the games the player wasn't in. A name must match in full: {@code Ada} isn't in a game of {@code Adam}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Mira played 4 games
     * Points: 2.5
     * }</pre>
     * Hints
     * 1. Read the games in a {@code while (true)} loop that stops at the empty line. Split each line at the commas: {@code parts[0]} is white, {@code parts[1]} black and {@code parts[2]} the result. When neither player {@code equals} the name, {@code continue}.
     * 2. A draw gives {@code points += 0.5;}. A win is {@code 1-0} when the player is white, or {@code 0-1} when the player is black. Keep {@code points} in a {@code double}, so it prints like {@code 2.5}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player = scanner.nextLine();

    }
}
