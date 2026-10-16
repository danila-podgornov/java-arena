// AI-Generated
package module37_streams_and_lambdas_ai.step09_a_loop_or_a_stream_ai.challenge03_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     * The closing challenge puts the module together. The bookshop's till writes each sale to {@code sales.csv}: the title, the number of copies and the price of one copy, separated by commas. {@code BookSale.java} is ready. Write {@code main} so that it reads the file into a {@code List<BookSale>} with {@code Files.lines}, and then uses streams to print:
     * <ul>
     * <li>the number of sales
     * <li>the number of copies sold, all sales together
     * <li>the takings: each sale's copies times its price ({@code total()}), added up
     * <li>the titles sold, each once, in alphabetical order
     * </ul>
     * <p>If the file can't be read, print only {@code Error: } and the exception's message. Use no loops. For the file shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Sales: 6
     * Copies: 12
     * Takings: 155 dollars
     * Titles: [Beloved, Dune, Emma, Kindred]
     * }</pre>
     * Hints
     * 1. Read the file as in step 8: {@code Files.lines(Paths.get("sales.csv"))}, a {@code map} that splits each line, a {@code map} that makes a {@code new BookSale(...)} with the two numbers turned into ints, and {@code collect(Collectors.toList())}. Do it all inside the {@code try} block.
     * 2. Then one stream per answer: the list's {@code size()} for the sales, {@code mapToInt(BookSale::getCopies).sum()}, {@code mapToInt(BookSale::total).sum()}, and {@code map(BookSale::getTitle)} with {@code distinct()}, {@code sorted()} and {@code collect}.
     */
    public static void main(String[] args) {

    }
}
