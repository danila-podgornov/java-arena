// AI-Generated
package module43_writing_files_ai.step01_writing_a_file_with_printwriter_ai;

import java.io.PrintWriter;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A time capsule program reads lines until the input ends, writes each of them into the file {@code capsule.txt}, and at the end prints how many lines it sealed in. Fill in the blanks. For the input shown below, it prints:
     * {@code Sealed 3 lines}
     * <p>and {@code capsule.txt} then holds the same three lines as the input.
     * Hints
     * 1. The first blank is the class that writes a file. The second writes a line and its line break into the file, as {@code System.out}'s method of the same name does on the screen.
     * 2. The last blank closes the file, so that the lines really reach it: {@code writer.close()}.
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new ___("capsule.txt");
        int count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            writer.___(line);
            count++;
        }
        writer.___();
        System.out.println("Sealed " + count + " lines");
    }
}
