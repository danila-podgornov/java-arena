// AI-Generated
package module57_switch_var_and_text_blocks_ai.step05_text_blocks_and_formatted_text_ai;

public class Challenge02Ai {
    /**
     * A dice game shows a line after each round. Write the method {@code roundLine(String player, int points, int round)}, which returns a line like {@code Round 03: Mia scored 12 points}: the round with at least two digits, padded with a zero in front, the player and the points. Build it with {@code String.format} (or {@code formatted}), without {@code +}. The check runs {@code System.out.println(roundLine("Mia", 12, 3));}, which prints: see the expected output below.
     * Expected output
     * {@code Round 03: Mia scored 12 points}
     * Hints
     * 1. The values fill the places in order, so the round comes first: {@code String.format("Round %02d: ...", round, ...)}.
     * 2. {@code %02d} is a whole number in at least two characters, padded with zeros: 3 becomes {@code 03}, 12 stays {@code 12}. Then {@code %s} for the player and {@code %d} for the points.
     */
    public static void main(String[] args) {
        System.out.println(roundLine("Mia", 12, 3));
    }

    public static String roundLine(String player, int points, int round) {
        return "";
    }
}
