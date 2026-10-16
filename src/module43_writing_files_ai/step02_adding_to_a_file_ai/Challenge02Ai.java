// AI-Generated
package module43_writing_files_ai.step02_adding_to_a_file_ai;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A calculator keeps its history in {@code history.txt}, and its method {@code save} writes a line there, appending or not. The folder is empty when the program starts. What does the program print?
     * Hints
     * 1. {@code new FileWriter("history.txt", true)} creates the file when it isn't there yet, and otherwise adds after what it holds. With {@code false}, it empties the file first.
     * 2. The third call empties the file, so the first two lines are gone. Only one call comes after it.
     */
    public static void main(String[] args) throws Exception {
        save("2 + 2 = 4", true);
        save("5 * 3 = 15", true);
        save("9 / 3 = 3", false);
        save("7 + 1 = 8", true);

        try (Scanner reader = new Scanner(Paths.get("history.txt"))) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        }
    }

    public static void save(String line, boolean append) throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("history.txt", append));
        writer.println(line);
        writer.close();
    }
}
