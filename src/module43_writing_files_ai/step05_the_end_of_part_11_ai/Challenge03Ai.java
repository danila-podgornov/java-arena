// AI-Generated
package module43_writing_files_ai.step05_the_end_of_part_11_ai;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Challenge03Ai {
    /**
     * Two roommates keep their own shopping lists, {@code mine.txt} and {@code yours.txt}, one item per line in small letters. Write the method {@code merge(String first, String second, String target)}, which writes every item of the files {@code first} and {@code second} into the file {@code target}, each item only once, in alphabetical order. The method prints nothing, and passes exceptions on with {@code throws Exception}.
     * <p>The check runs {@code merge("mine.txt", "yours.txt", "shared.txt");} with the files shown below, and after it {@code shared.txt} should hold: see the expected output below.
     * Expected output
     * <pre>{@code
     * apples
     * bread
     * coffee
     * milk
     * }</pre>
     * Hints
     * 1. Collect the items of both files into one list, adding an item only when the list doesn't contain it yet. {@code Files.readAllLines(Paths.get(first))} returns a file's lines as a list you can loop over.
     * 2. {@code Collections.sort(items)} puts the list in alphabetical order. Then write it with a PrintWriter in a try-with-resources, one item per line.
     */
    public static void main(String[] args) throws Exception {
        merge("mine.txt", "yours.txt", "shared.txt");
    }

    // Write the method merge here.
}
