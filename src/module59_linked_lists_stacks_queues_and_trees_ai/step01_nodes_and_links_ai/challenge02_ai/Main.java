// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step01_nodes_and_links_ai.challenge02_ai;

public class Main {
    /**
     * Write the method {@code route(Clue first)} in {@code Main.java}. It returns the places of the hunt in order, each followed by {@code ->}, and then the word {@code finish}. An empty hunt ({@code first} is {@code null}) gives just {@code finish}. Go along the chain with a loop over {@code next}. The check runs:
     * <pre>{@code
     * Clue gate = new Clue("the gate", 5);
     * gate.next = new Clue("the pond", 15);
     * gate.next.next = new Clue("the red bench", 25);
     * System.out.println(route(gate));
     * System.out.println(route(gate.next.next));
     * System.out.println(route(null));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * the gate -> the pond -> the red bench -> finish
     * the red bench -> finish
     * finish
     * }</pre>
     * Hints
     * 1. Start with an empty String and a variable {@code current} at {@code first}. While {@code current} isn't {@code null}, add its place and {@code ->}, and move on.
     * 2. After the loop, add {@code finish}. For an empty hunt the loop doesn't run at all, so the result is just {@code finish}, with no special case needed.
     */
    public static void main(String[] args) {
        Clue gate = new Clue("the gate", 5);
        gate.next = new Clue("the pond", 15);
        gate.next.next = new Clue("the red bench", 25);
        System.out.println(route(gate));
        System.out.println(route(gate.next.next));
        System.out.println(route(null));
    }

    public static String route(Clue first) {
        return "";
    }
}
