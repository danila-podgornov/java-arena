// AI-Generated
package module59_linked_lists_stacks_queues_and_trees_ai.step03_stacks_and_queues_on_linked_nodes_ai.challenge03_ai;

public class Main {
    /**
     * A spreadsheet checks the brackets in a formula before it calculates anything. Write the method {@code balanced(String formula)} in {@code Main.java}. It returns {@code true} when every bracket, {@code (}, {@code [} and <code>{</code>, is closed by the matching {@code )}, {@code ]} or <code>}</code> in the right order, and {@code false} otherwise. Other characters don't matter. Use the stack of characters in {@code CharStack.java} (it has {@code push}, {@code pop}, {@code peek} and {@code isEmpty}; {@code pop} and {@code peek} throw an exception on an empty stack, so check {@code isEmpty()} first), the way the lesson describes. The check runs:
     * <pre>{@code
     * System.out.println(balanced("=SUM((A1+B2)*[C3])"));
     * System.out.println(balanced("=MAX(A1,{B2)}"));
     * System.out.println(balanced("=(A1+B2"));
     * System.out.println(balanced("=A1)"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * false
     * false
     * }</pre>
     * Hints
     * 1. Go through the formula with {@code charAt}. Push each opening bracket. For a closing bracket, return {@code false} at once if the stack is empty; otherwise pop and compare: a {@code )} needs a {@code (}, a {@code ]} a {@code [}, and a <code>}</code> a <code>{</code>.
     * 2. After the loop, every opening bracket must have been closed: {@code return open.isEmpty();}.
     */
    public static void main(String[] args) {
        System.out.println(balanced("=SUM((A1+B2)*[C3])"));
        System.out.println(balanced("=MAX(A1,{B2)}"));
        System.out.println(balanced("=(A1+B2"));
        System.out.println(balanced("=A1)"));
    }

    public static boolean balanced(String formula) {
        return true;
    }
}
