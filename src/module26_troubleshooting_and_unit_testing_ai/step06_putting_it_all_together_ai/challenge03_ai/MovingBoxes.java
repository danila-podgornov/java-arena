// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step06_putting_it_all_together_ai.challenge03_ai;

import java.util.Scanner;

/**
 * On moving day, the list of boxes is read from a Scanner, one box per line, until the input ends. A line that starts with {@code x } (an x and a space) is a box that's on the van already, like {@code x books}, and any other line is a box still to load. Empty lines are skipped. Write {@code MovingBoxes} so the tests of {@code MovingBoxesTest} pass:
 * <ul>
 * <li>{@code read(Scanner scanner)} reads the lines. Calling it again reads more boxes onto the same list.
 * <li>{@code loadedCount()} returns how many boxes are on the van, and {@code leftToLoad()} how many are not.
 * <li>{@code isDone()} returns {@code true} when no box is left to load.
 * </ul>
 * <p>The checks run the tests of {@code MovingBoxesTest} as they are given here (changing them won't help), and more tests of their own.
 * Hints
 * 1. The tests only ask for counts, so two {@code int} instance variables are enough: how many boxes are loaded and how many are left. {@code read} goes through the lines with {@code while (scanner.hasNextLine())}.
 * 2. For each line: {@code if (line.startsWith("x ")) { this.loaded++; } else if (!line.isEmpty()) { this.left++; }}. {@code isDone()} is {@code return this.left == 0;}.
 */
public class MovingBoxes {
    public MovingBoxes() {
    }

    public void read(Scanner scanner) {
    }

    public int loadedCount() {
        return 0;
    }

    public int leftToLoad() {
        return 0;
    }

    public boolean isDone() {
        return false;
    }
}
