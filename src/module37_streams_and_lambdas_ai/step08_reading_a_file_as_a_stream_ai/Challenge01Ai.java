// AI-Generated
package module37_streams_and_lambdas_ai.step08_reading_a_file_as_a_stream_ai;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Challenge01Ai {
    /**
     * This challenge gives the file {@code expenses.csv}, shown below, in the same form: the category and the amount, separated by a comma. Print the total of the grocery expenses, the lines whose category is exactly {@code groceries}. Use {@code Files.lines} and a stream, in a {@code try} block. If the file can't be read, print only {@code Error: } and the exception's message. For the file shown, the program prints: see the expected output below.
     * Expected output
     * {@code Groceries: 92}
     * Hints
     * 1. Split each line first, {@code map(line -> line.split(","))}, and then keep the arrays whose first part equals {@code groceries}, with {@code equals}, since a category such as {@code groceries extra} also starts with {@code groceries}.
     * 2. Then {@code mapToInt(parts -> Integer.valueOf(parts[1]))} and {@code sum()}. Print inside the {@code try} block: then only the error is printed when the file can't be read.
     */
    public static void main(String[] args) {

    }
}
