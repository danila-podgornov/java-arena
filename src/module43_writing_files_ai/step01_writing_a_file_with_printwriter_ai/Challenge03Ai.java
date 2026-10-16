// AI-Generated
package module43_writing_files_ai.step01_writing_a_file_with_printwriter_ai;

import java.io.PrintWriter;

public class Challenge03Ai {
    /**
     * A teacher wants practice sheets for the multiplication table. Write the method {@code writeGrid(String fileName, int size)}, which writes a grid of products into the file: {@code size} lines, where line number {@code row} (counting from 1) holds {@code row * 1}, {@code row * 2} and so on up to {@code row * size}, with a space between the numbers. The method prints nothing. Creating a PrintWriter may throw, so the method's header needs {@code throws Exception}.
     * <p>The check runs {@code writeGrid("grid.txt", 4);}, and after it {@code grid.txt} should hold: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1 2 3 4
     * 2 4 6 8
     * 3 6 9 12
     * 4 8 12 16
     * }</pre>
     * Hints
     * 1. Two loops, one inside the other: the outer one goes through the rows and the inner one through the columns. {@code writer.print(row * column + " ")} writes a number and a space without ending the line. A space at the end of a line doesn't matter to the check.
     * 2. After the inner loop, {@code writer.println()} ends the row. After both loops, {@code writer.close()}. And add {@code throws Exception} after the method's parentheses.
     */
    public static void main(String[] args) throws Exception {
        writeGrid("grid.txt", 4);
    }

    public static void writeGrid(String fileName, int size) {
        // Write the grid into the file here.
    }
}
