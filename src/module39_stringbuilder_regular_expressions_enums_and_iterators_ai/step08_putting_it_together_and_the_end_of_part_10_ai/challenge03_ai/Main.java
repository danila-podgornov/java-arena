// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step08_putting_it_together_and_the_end_of_part_10_ai.challenge03_ai;

public class Main {
    /**
     * To end part 10: the festival's box office. {@code Pass.java} is the one from the first task, and {@code Ticket.java} is ready: a ticket has the name of its holder and a Pass. One person can hold several tickets. In {@code BoxOffice.java}, {@code sell} is ready. Write:
     * <ul>
     * <li>{@code refund(String holder)}, for a person who can't come after all: it removes every ticket of that holder, with an iterator, and returns the money that goes back, the sum of the prices of the removed tickets' passes (0 when the holder has no tickets)
     * <li>{@code report()}, which returns a String built with a StringBuilder: one line for each pass, in the order of {@code Pass.values()}, like {@code DAY: 3 sold, 135 dollars}, with a line break between the lines and none after the last
     * </ul>
     * <p>{@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * DAY: 3 sold, 135 dollars
     * WEEKEND: 1 sold, 110 dollars
     * BACKSTAGE: 1 sold, 250 dollars
     * Refunded: 405
     * DAY: 2 sold, 90 dollars
     * WEEKEND: 0 sold, 0 dollars
     * BACKSTAGE: 0 sold, 0 dollars
     * }</pre>
     * Hints
     * 1. {@code refund} is step 7's loop: an iterator over {@code this.tickets}. Keep the ticket from {@code next()} in a variable, since you need both its holder and its pass. When the holder {@code equals} the name asked for, call {@code iterator.remove()} and add {@code ticket.getPass().getPrice()} to the money. Return the money after the loop.
     * 2. {@code report} makes one StringBuilder, and for each pass in {@code Pass.values()} counts the tickets of that pass with a for-each loop. Before every line but the first (when {@code report.length() > 0}), append {@code "\n"}; then append the pass, the count and {@code count * pass.getPrice()} with the words in between.
     */
    public static void main(String[] args) {
        BoxOffice office = new BoxOffice();
        office.sell("Ada", Pass.DAY);
        office.sell("Ben", Pass.WEEKEND);
        office.sell("Ben", Pass.BACKSTAGE);
        office.sell("Cy", Pass.DAY);
        office.sell("Ben", Pass.DAY);
        System.out.println(office.report());
        System.out.println("Refunded: " + office.refund("Ben"));
        System.out.println(office.report());
    }
}
