// AI-Generated
package module51_data_visualization_ai.step01_from_text_rows_to_numbers_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Challenge01Ai {
    /**
     * The school library counts its loans each month, in the tab-separated file {@code loans.tsv}. The library was closed for a month, so that month has a {@code -}. Fill in the blanks, so that the program prints each month with its loans (or {@code closed}), then the busiest month:
     * <pre>{@code
     * month	loans
     * Jan	412
     * Feb	388
     * Mar	455
     * Apr	-
     * May	301
     * }</pre>
     * <p>The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * Jan: 412
     * Feb: 388
     * Mar: 455
     * Apr: closed
     * May: 301
     * Busiest month: Mar
     * }</pre>
     * Hints
     * 1. The first line of the file is the header. Which index does the loop start from to skip it? Which character separates the values in a {@code .tsv} file, and which method of {@code Integer} turns text into a number?
     * 2. The loop starts at index 1, after the header. The values are separated by a tab, written {@code \t} inside a string. {@code Integer.valueOf} turns a text of digits into a number.
     */
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("loans.tsv"));
        String busiest = "";
        int most = 0;
        for (int i = ___; i < lines.size(); i++) {
            String[] parts = lines.get(i).split("___");
            if (parts[1].equals("-")) {
                System.out.println(parts[0] + ": closed");
            } else {
                int loans = Integer.___(parts[1]);
                System.out.println(parts[0] + ": " + loans);
                if (loans > most) {
                    most = loans;
                    busiest = parts[0];
                }
            }
        }
        System.out.println("Busiest month: " + busiest);
    }
}
