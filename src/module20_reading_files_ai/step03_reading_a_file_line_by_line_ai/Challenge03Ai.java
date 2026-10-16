// AI-Generated
package module20_reading_files_ai.step03_reading_a_file_line_by_line_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * This program reads a String with a Scanner. What does it print? Look closely at the String: {@code \n} is a line break.
     * Hints
     * 1. Two line breaks in a row, {@code \n\n}, leave an empty line between them.
     * 2. An empty line is a line too: it's read and counted, and its length is 0.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner("ant\nbee\n\ncat");
        int lines = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines++;
            System.out.println(lines + ": " + line.length());
        }
    }
}
