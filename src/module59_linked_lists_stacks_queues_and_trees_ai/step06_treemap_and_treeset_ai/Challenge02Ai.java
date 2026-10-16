// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step06_treemap_and_treeset_ai;

import java.util.Scanner;
import java.util.TreeSet;

public class Challenge02Ai {
    /**
     * A beach's tide board shows, for any time you ask about, the last tide (high or low) at or before that time and the next one at or after it. The first line of the input has the tide times, in {@code HH:MM} form and in any order, separated by spaces. Each line after it is a time asked about, until the line {@code end}. For each, the program prints the time, {@code : previous }, the latest tide at or before it, {@code , next }, and the earliest tide at or after it. When there's no such tide, it prints {@code none} in its place. Keep the tide times in a TreeSet and use {@code floor} and {@code ceiling}. With this input:
     * <p>Input
     * <pre>{@code
     * 07:30 06:40 08:15 07:05
     * 07:20
     * 07:30
     * 06:00
     * 09:00
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 07:20: previous 07:05, next 07:30
     * 07:30: previous 07:30, next 07:30
     * 06:00: previous none, next 06:40
     * 09:00: previous 08:15, next none
     * }</pre>
     * Hints
     * 1. Read the first line, split it with {@code split(" ")}, and add each time to a {@code TreeSet<String>}. Times in {@code HH:MM} form sort correctly as Strings.
     * 2. {@code tides.floor(time)} is the latest tide at or before the time, and {@code tides.ceiling(time)} the earliest at or after it. Each is {@code null} when there's none: print {@code none} then.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
