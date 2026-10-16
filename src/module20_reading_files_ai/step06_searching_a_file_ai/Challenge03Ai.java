// AI-Generated
package module20_reading_files_ai.step06_searching_a_file_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * What does this program print? Compare {@code equals} and {@code contains} on every line.
     * Hints
     * 1. Only one line is exactly {@code tea}. {@code Tea cake} starts with a capital T, so neither check matches it.
     * 2. Look inside {@code steam}: s, t, e, a, m.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner("green tea\ntea\nTea cake\nsteam");
        int same = 0;
        int inside = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("tea")) {
                same++;
            }
            if (line.contains("tea")) {
                inside++;
            }
        }
        System.out.println("equals: " + same);
        System.out.println("contains: " + inside);
    }
}
