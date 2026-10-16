// AI-Generated
package module24_lists_inside_objects_ai.step03_methods_that_go_through_the_list_ai.challenge03_ai;

public class Main {
    /**
     * A guestbook keeps a name for every visit, so the same name can be in it many times. {@code Guestbook.java} has the list and the method {@code sign(String name)}. Write two more methods:
     * <ul>
     * <li>{@code visits(String name)} returns how many times the name is in the guestbook. {@code contains} can't count, so go through the list yourself, and compare the names with {@code equals}.
     * <li>{@code printNames()} prints every name once, in the order of their first visits.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Guestbook book = new Guestbook();
     * book.sign("Ada");
     * book.sign("Leo");
     * book.sign("Ada");
     * book.sign("Mia");
     * book.sign("Ada");
     * System.out.println(book.visits("Ada") + " " + book.visits("Leo") + " " + book.visits("Zed"));
     * book.printNames();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 1 0
     * Ada
     * Leo
     * Mia
     * }</pre>
     * Hints
     * 1. {@code visits} counts in a loop: start with {@code int count = 0;}, go through {@code this.names}, and add one when {@code visitor.equals(name)}. Return the count after the loop.
     * 2. For {@code printNames}, keep a local list of the names already printed. For each name in the guestbook: if {@code printed} doesn't contain it yet, print it and add it to {@code printed}.
     */
    public static void main(String[] args) {
        Guestbook book = new Guestbook();
        book.sign("Ada");
        book.sign("Leo");
        book.sign("Ada");
        book.sign("Mia");
        book.sign("Ada");
        System.out.println(book.visits("Ada") + " " + book.visits("Leo") + " " + book.visits("Zed"));
        book.printNames();
    }
}
