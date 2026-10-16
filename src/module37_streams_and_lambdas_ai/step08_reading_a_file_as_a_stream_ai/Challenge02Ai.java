// AI-Generated
package module37_streams_and_lambdas_ai.step08_reading_a_file_as_a_stream_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge02Ai {
    /**
     * The bank's export starts with a header line, {@code category,amount}, before the expenses. Fill in the blank, a stream method, so that the program leaves the header out and prints the number of expenses and their total. For the file shown, it prints: see the expected output below.
     * Expected output
     * {@code 3 expenses, 136 dollars}
     * Hints
     * 1. {@code Integer.valueOf("amount")} would crash on the header, so it must be dropped before that {@code map}. Which intermediate operation drops the first values?
     * 2. {@code skip(1)} drops the first line and lets the rest through.
     */
    public static void main(String[] args) {
        try {
            List<Integer> amounts = Files.lines(Paths.get("export.csv"))
                    .___(1)
                    .map(line -> line.split(","))
                    .map(parts -> Integer.valueOf(parts[1]))
                    .collect(Collectors.toList());
            int total = amounts.stream()
                    .mapToInt(amount -> amount)
                    .sum();
            System.out.println(amounts.size() + " expenses, " + total + " dollars");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
