// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step01_nodes_and_links_ai.challenge03_ai;

public class Main {
    /**
     * Write two methods in {@code Main.java}:
     * <ul>
     * <li>{@code count(Clue first)} returns how many clues the hunt has (0 for an empty hunt);
     * <li>{@code best(Clue first)} returns the clue worth the most points. When two clues tie, it returns the first of them. For an empty hunt it returns {@code null}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Clue well = new Clue("the well", 8);
     * well.next = new Clue("the barn", 30);
     * well.next.next = new Clue("the hill", 12);
     * well.next.next.next = new Clue("the shop", 30);
     * System.out.println(count(well) + " clues");
     * System.out.println("Best: " + best(well).place);
     * System.out.println(count(null) + " clues");
     * System.out.println(best(null) == null);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 4 clues
     * Best: the barn
     * 0 clues
     * true
     * }</pre>
     * Hints
     * 1. {@code count} is the walking loop of the lesson with a counter in place of the sum.
     * 2. In {@code best}, keep the best clue so far in a variable that starts at {@code first} (which is {@code null} for an empty hunt, the right answer then). Replace it only when a clue has strictly more points, so that the first of a tie stays.
     */
    public static void main(String[] args) {
        Clue well = new Clue("the well", 8);
        well.next = new Clue("the barn", 30);
        well.next.next = new Clue("the hill", 12);
        well.next.next.next = new Clue("the shop", 30);
        System.out.println(count(well) + " clues");
        System.out.println("Best: " + best(well).place);
        System.out.println(count(null) + " clues");
        System.out.println(best(null) == null);
    }

    public static int count(Clue first) {
        return 0;
    }

    public static Clue best(Clue first) {
        return first;
    }
}
