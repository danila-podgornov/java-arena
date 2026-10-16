// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step06_a_class_that_remembers_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * Now use the finished {@code RainLog} in a program that gives a one-line verdict on the weather. Read the rain of each day, one number per line, until an empty line, and add each number to a {@code RainLog}. Then print one line:
     * <ul>
     * <li>{@code Drought warning: } and the longest dry spell followed by {@code  dry days in a row}, when the longest dry spell is 3 days or more;
     * <li>otherwise {@code Flood watch: } and the wettest day's rain followed by {@code  mm in one day}, when the wettest day had 20 mm or more;
     * <li>otherwise {@code Normal weather}.
     * </ul>
     * <p>For the input {@code 0}, {@code 0}, {@code 4}, {@code 0}, {@code 0}, {@code 0}, {@code 1} and an empty line, the program prints: see the expected output below.
     * Expected output
     * {@code Drought warning: 3 dry days in a row}
     * Hints
     * 1. A {@code while (true)} loop reads a line, stops with {@code break} when {@code line.isEmpty()}, and otherwise calls {@code log.add(Integer.valueOf(line));}.
     * 2. After the loop, ask the log: {@code if (log.longestDrySpell() >= 3) { ... } else if (log.wettest() >= 20) { ... } else { ... }}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RainLog log = new RainLog();

    }
}
