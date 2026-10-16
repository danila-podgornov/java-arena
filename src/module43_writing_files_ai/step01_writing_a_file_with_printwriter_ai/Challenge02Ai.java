// AI-Generated
package module43_writing_files_ai.step01_writing_a_file_with_printwriter_ai;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A shop writes the sign for its door with {@code print} and {@code println}, and then reads the file back, printing each line between brackets after its number. What does the program print?
     * Hints
     * 1. {@code print} doesn't end the line, so {@code Open} and {@code  daily} end up on one line. {@code println()} with nothing in the parentheses writes only a line break, which makes an empty line.
     * 2. The last two {@code print}s aren't followed by a line break, but their text is still a line of the file: the last one.
     */
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("sign.txt");
        writer.print("Open");
        writer.println(" daily");
        writer.println();
        writer.print("Closed");
        writer.print(" on May 1");
        writer.close();

        try (Scanner reader = new Scanner(Paths.get("sign.txt"))) {
            int number = 1;
            while (reader.hasNextLine()) {
                System.out.println(number + " [" + reader.nextLine() + "]");
                number++;
            }
        }
    }
}
