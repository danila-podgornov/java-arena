// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step01_nodes_and_links_ai.challenge01_ai;

public class Main {
    /**
     * Fill in the blanks so that the hunt goes from the gate to the pond to the red bench, and the loop prints each clue's place and points. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * the gate: 5
     * the pond: 15
     * the red bench: 25
     * }</pre>
     * Hints
     * 1. The gate's {@code next} should refer to the pond, and the pond's {@code next} to the bench. The bench's {@code next} stays {@code null}.
     * 2. The loop runs while {@code current} refers to a clue, so the test is {@code current != null}. Each round moves it one clue on: {@code current = current.next;}.
     */
    public static void main(String[] args) {
        Clue gate = new Clue("the gate", 5);
        Clue pond = new Clue("the pond", 15);
        Clue bench = new Clue("the red bench", 25);
        gate.next = ___;
        pond.___ = bench;

        Clue current = gate;
        while (current ___ null) {
            System.out.println(current.place + ": " + current.points);
            current = ___;
        }
    }
}
