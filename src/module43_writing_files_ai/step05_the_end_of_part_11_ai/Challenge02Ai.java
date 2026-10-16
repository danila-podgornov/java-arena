// AI-Generated
package module43_writing_files_ai.step05_the_end_of_part_11_ai;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Challenge02Ai {
    /**
     * A last look at exceptions and files together. {@code save} throws an IllegalArgumentException for an empty item, and one of the files is to go into a folder that doesn't exist. {@code Files.readAllLines} returns a file's lines in a list. What does the program print?
     * Hints
     * 1. In the first call, {@code eggs} is written, and then the empty item throws. The writer is closed on the way out, the first {@code catch} block prints its line, and {@code finally} prints {@code done}. {@code saved list.txt} is never printed.
     * 2. In the second call, creating the PrintWriter already throws a FileNotFoundException, since there's no folder {@code shop}. Last, {@code list.txt} holds the one line written before the problem.
     */
    public static void main(String[] args) throws Exception {
        String[] items = {"eggs", "", "milk"};
        save("list.txt", items);
        save("shop/list.txt", items);
        System.out.println(Files.readAllLines(Paths.get("list.txt")));
    }

    public static void save(String fileName, String[] items) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String item : items) {
                if (item.isEmpty()) {
                    throw new IllegalArgumentException("empty item");
                }
                writer.println(item);
            }
            System.out.println("saved " + fileName);
        } catch (IllegalArgumentException e) {
            System.out.println("stopped: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("no folder for " + fileName);
        } finally {
            System.out.println("done");
        }
    }
}
