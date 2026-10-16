// AI-Generated
package module56_records_ai.step03_checking_values_with_a_compact_constructor_ai.challenge03_ai;

public class Main {
    /**
     * A print dialog takes a range of pages, from the first to the last. People sometimes type the range backwards, 9 to 4, which should print the same pages as 4 to 9. In {@code PageRange.java}, give the record {@code PageRange(int first, int last)} a compact constructor that swaps the two numbers when {@code first} is greater than {@code last}, so a PageRange is always in order. The check runs:
     * <pre>{@code
     * PageRange typed = new PageRange(9, 4);
     * System.out.println(typed);
     * System.out.println(typed.equals(new PageRange(4, 9)));
     * System.out.println(new PageRange(2, 2));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * PageRange[first=4, last=9]
     * true
     * PageRange[first=2, last=2]
     * }</pre>
     * Hints
     * 1. Swapping two variables needs a third one to hold a value for a moment: keep {@code last} in a helper variable, set {@code last = first}, then {@code first} gets the helper's value.
     * 2. Do it only {@code if (first > last)}. A range that's already in order, or one page long, stays as it is.
     */
    public static void main(String[] args) {
        PageRange typed = new PageRange(9, 4);
        System.out.println(typed);
        System.out.println(typed.equals(new PageRange(4, 9)));
        System.out.println(new PageRange(2, 2));
    }
}
