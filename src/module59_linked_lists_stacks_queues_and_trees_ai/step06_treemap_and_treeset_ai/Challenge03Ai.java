// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step06_treemap_and_treeset_ai;

import java.util.Scanner;
import java.util.TreeMap;

public class Challenge03Ai {
    /**
     * A gardener keeps a journal with a note for some days of the year. The program reads lines until {@code end}. Each line is a date in {@code yyyy-mm-dd} form, a space, and the note, such as {@code 2024-05-03 planted beans}. The lines aren't in date order, and a later line with the same date replaces that date's note. Keep the notes in a TreeMap from date to note. At the end, print every note in date order, as the date, a colon, a space and the note. Then print {@code from }, the first date, {@code to} and the last date, using {@code firstKey} and {@code lastKey}. With no notes at all, print only {@code no notes}. With this input:
     * <p>Input
     * <pre>{@code
     * 2024-05-03 planted beans
     * 2024-04-20 sowed tomatoes
     * 2024-06-11 first strawberry
     * 2024-05-03 planted beans and peas
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2024-04-20: sowed tomatoes
     * 2024-05-03: planted beans and peas
     * 2024-06-11: first strawberry
     * from 2024-04-20 to 2024-06-11
     * }</pre>
     * Hints
     * 1. A date is the first 10 characters of a line, {@code line.substring(0, 10)}, and the note is everything after the space, {@code line.substring(11)}. {@code put} replaces the note of a date that's already there.
     * 2. Check {@code journal.isEmpty()} before calling {@code firstKey}: on an empty TreeMap it throws a NoSuchElementException. Go through {@code journal.entrySet()} with {@code var entry}, as in module 57.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
