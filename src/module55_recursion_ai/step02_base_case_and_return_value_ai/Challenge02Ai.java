// AI-Generated
package module55_recursion_ai.step02_base_case_and_return_value_ai;

public class Challenge02Ai {
    /**
     * A bookshop owner wants to know in how many different orders a number of books can stand on a shelf. One book stands in 1 order. With 2 books there are 2 orders, and with 3 books 6: any of the 3 can stand first, and the other 2 stand after it in 2 orders. In general, {@code n} books stand in {@code n} times as many orders as {@code n - 1} books. That's the factorial of {@code n}, written {@code n!}. An empty shelf counts as 1 order ({@code 0! = 1}).
     * <p>The numbers grow fast, so write the method {@code orders(int books)} that returns a {@code long}, with recursion and no loop. A {@code long} holds factorials up to {@code 20!}. The check runs:
     * <pre>{@code
     * System.out.println(orders(3));
     * System.out.println(orders(0));
     * System.out.println(orders(15));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 6
     * 1
     * 1307674368000
     * }</pre>
     * Hints
     * 1. The base case is an empty shelf: {@code if (books == 0)}, return 1.
     * 2. Otherwise the answer is {@code books} times the orders of one book fewer: {@code return books * orders(books - 1);}. Since {@code orders} returns a long, the multiplication is done with longs.
     */
    public static void main(String[] args) {
        System.out.println(orders(3));
        System.out.println(orders(0));
        System.out.println(orders(15));
    }

    // Write the method orders here.
}
