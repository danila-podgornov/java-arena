// AI-Generated
package module37_streams_and_lambdas_ai.step09_a_loop_or_a_stream_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     * The bookshop's app has a method with a loop. {@code BookSale.java} is ready: each sale has a title, the number of copies and the price of one copy. {@code bestSellers} returns the titles that had a sale of at least {@code minCopies} copies, each once, in alphabetical order. Rewrite its body with a stream, with no loop and no {@code Collections.sort}, and keep its header as it is. The check runs:
     * <pre>{@code
     * List<BookSale> sales = new ArrayList<>();
     * sales.add(new BookSale("Kindred", 3, 14));
     * sales.add(new BookSale("Emma", 1, 12));
     * sales.add(new BookSale("Beloved", 2, 15));
     * sales.add(new BookSale("Kindred", 4, 14));
     * System.out.println(bestSellers(sales, 2));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Beloved, Kindred]}
     * Hints
     * 1. Name each part of the loop as a stream step: the {@code if} on the copies is a {@code filter}, taking the title is a {@code map}, the {@code contains} check is {@code distinct()}, and {@code Collections.sort} is {@code sorted()}.
     * 2. {@code return sales.stream().filter(sale -> sale.getCopies() >= minCopies).map(BookSale::getTitle).distinct().sorted().collect(Collectors.toList());}
     */
    public static void main(String[] args) {
        List<BookSale> sales = new ArrayList<>();
        sales.add(new BookSale("Kindred", 3, 14));
        sales.add(new BookSale("Emma", 1, 12));
        sales.add(new BookSale("Beloved", 2, 15));
        sales.add(new BookSale("Kindred", 4, 14));
        System.out.println(bestSellers(sales, 2));
    }

    public static List<String> bestSellers(List<BookSale> sales, int minCopies) {
        List<String> titles = new ArrayList<>();
        for (BookSale sale : sales) {
            if (sale.getCopies() >= minCopies && !titles.contains(sale.getTitle())) {
                titles.add(sale.getTitle());
            }
        }
        Collections.sort(titles);
        return titles;
    }
}
