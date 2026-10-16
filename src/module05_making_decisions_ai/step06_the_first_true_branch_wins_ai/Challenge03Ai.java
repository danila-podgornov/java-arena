// AI-Generated
package module05_making_decisions_ai.step06_the_first_true_branch_wins_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A finer scale, and a check on the input. Scores go from 0 to 100; anything else is {@code Invalid score}. The grades (an invented scale for this exercise):
     * <table>
     * <tr><th>Score</th><th>Grade</th></tr>
     * <tr><td>95 to 100</td><td>{@code A+}</td></tr>
     * <tr><td>85 to 94</td><td>{@code A}</td></tr>
     * <tr><td>75 to 84</td><td>{@code B}</td></tr>
     * <tr><td>65 to 74</td><td>{@code C}</td></tr>
     * <tr><td>55 to 64</td><td>{@code D}</td></tr>
     * <tr><td>45 to 54</td><td>{@code E}</td></tr>
     * <tr><td>0 to 44</td><td>{@code F}</td></tr>
     * </table>
     * <p>For the input {@code 88} the program prints: see the expected output below.
     * Expected output
     * {@code A}
     * Hints
     * 1. Check for scores over 100 first, then go down the bands from the top.
     * 2. What's left after {@code score >= 0} is negative: that's invalid too, so the final {@code else} prints {@code Invalid score}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = Integer.valueOf(scanner.nextLine());

    }
}
