// AI-Generated
package module43_writing_files_ai.step03_try_with_resources_and_objects_in_a_file_ai;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Challenge02Ai {
    /**
     * Two ways to write the same numbers, and one of the entries isn't a number. {@code Files.readAllLines} (module 42) returns a file's lines in a list. What does the program print?
     * Hints
     * 1. In both, {@code parseInt("many")} throws in the third round, so {@code 3} is never written, and each {@code catch} block prints its line.
     * 2. In the first, the exception skips {@code writer.close()}, so the text the PrintWriter was holding never reaches {@code first.txt}, and the list is empty. try-with-resources closes the second writer on the way out, so {@code second.txt} has the lines written before the problem.
     */
    public static void main(String[] args) throws Exception {
        String[] entries = {"7", "12", "many", "3"};

        try {
            PrintWriter writer = new PrintWriter("first.txt");
            for (String entry : entries) {
                writer.println(Integer.parseInt(entry));
            }
            writer.close();
        } catch (NumberFormatException e) {
            System.out.println("first: bad entry");
        }

        try (PrintWriter writer = new PrintWriter("second.txt")) {
            for (String entry : entries) {
                writer.println(Integer.parseInt(entry));
            }
        } catch (NumberFormatException e) {
            System.out.println("second: bad entry");
        }

        System.out.println(Files.readAllLines(Paths.get("first.txt")));
        System.out.println(Files.readAllLines(Paths.get("second.txt")));
    }
}
