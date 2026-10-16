// AI-Generated
package module57_switch_var_and_text_blocks_ai.step04_var_for_local_variables_ai;

import java.util.Scanner;
import java.util.TreeMap;

public class Challenge03Ai {
    /**
     * A board game club checks its dice by counting how often each face comes up. The program reads rolls, one whole number per line, until the line {@code end}, and counts them in a {@code TreeMap}. Write the loop that prints each face that came up and its count, like {@code 3: 2}, smallest face first. Go through the map's {@code entrySet()} with a {@code var} loop variable. With this input:
     * <p>Input
     * <pre>{@code
     * 6
     * 3
     * 6
     * 1
     * 3
     * 6
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1: 1
     * 3: 2
     * 6: 3
     * }</pre>
     * Hints
     * 1. <code>for (var entry : counts.entrySet()) {</code> goes through the entries, smallest key first, since a TreeMap keeps its keys sorted.
     * 2. Each entry has {@code getKey()}, the face, and {@code getValue()}, its count.
     */
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var counts = new TreeMap<Integer, Integer>();
        while (true) {
            var line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            var face = Integer.valueOf(line);
            counts.put(face, counts.getOrDefault(face, 0) + 1);
        }
        // print each face and its count

    }
}
