// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step02_test_input_for_a_scanner_ai.challenge03_ai;

public class Main {
    /**
     * A lap timer reads lap times in seconds, one per line, until the input ends. Its method {@code readLaps} makes its own Scanner, so it can only ever read the keyboard, and nobody has tried it with no laps at all. Do two things:
     * <ul>
     * <li>Change {@code readLaps} to take the Scanner as a parameter, {@code readLaps(Scanner scanner)}, and make {@code main} give it {@code new Scanner(System.in)}.
     * <li>With no laps, {@code fastest()} crashes. Make it return 0 then.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * LapTimer timer = new LapTimer();
     * timer.readLaps(new Scanner("62\n58\n60\n"));
     * System.out.println(timer.count() + " laps, fastest " + timer.fastest());
     * LapTimer none = new LapTimer();
     * none.readLaps(new Scanner(""));
     * System.out.println(none.count() + " laps, fastest " + none.fastest());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 laps, fastest 58
     * 0 laps, fastest 0
     * }</pre>
     * Hints
     * 1. Move the Scanner from the first line of {@code readLaps} into its parentheses: {@code public void readLaps(Scanner scanner)}. In {@code main}, call {@code timer.readLaps(new Scanner(System.in));}, and add {@code import java.util.Scanner;} to {@code Main.java}.
     * 2. {@code this.laps.get(0)} crashes on an empty list. Start {@code fastest()} with {@code if (this.laps.isEmpty()) { return 0; }}.
     */
    public static void main(String[] args) {
        LapTimer timer = new LapTimer();
        timer.readLaps();
        System.out.println(timer.count() + " laps, fastest " + timer.fastest());
    }
}
