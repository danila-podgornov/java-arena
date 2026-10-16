// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step02_a_linked_list_class_ai.challenge01_ai;

public class Main {
    /**
     * {@code ReadingList.java} is the class above, without {@code printAll}. Give it a method {@code toString()} that returns the titles from front to back, in square brackets and separated by a comma and a space, like an ArrayList prints: {@code [Beloved, Dune, Emma]}. An empty list gives {@code []}. The check runs:
     * <pre>{@code
     * ReadingList list = new ReadingList();
     * System.out.println(list);
     * list.addFirst("Emma");
     * list.addFirst("Dune");
     * list.addFirst("Beloved");
     * System.out.println(list);
     * System.out.println(list.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * []
     * [Beloved, Dune, Emma]
     * 3
     * }</pre>
     * Hints
     * 1. The header is {@code public String toString()}, with {@code @Override} above it. Walk from {@code this.head} with a {@code current} variable, as {@code printAll} did, and build a String.
     * 2. Put {@code , } between titles, not after the last one: add it only when {@code current.next != null}. Start with {@code [} and end with {@code ]}.
     */
    public static void main(String[] args) {
        ReadingList list = new ReadingList();
        System.out.println(list);
        list.addFirst("Emma");
        list.addFirst("Dune");
        list.addFirst("Beloved");
        System.out.println(list);
        System.out.println(list.size());
    }
}
