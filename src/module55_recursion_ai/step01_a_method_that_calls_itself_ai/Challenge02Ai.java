// AI-Generated
package module55_recursion_ai.step01_a_method_that_calls_itself_ai;

public class Challenge02Ai {
    /**
     * A tall building's stairwell has the floor number painted on each landing, and someone climbing it passes them in order. Write the method {@code floorsUp(int top)}, which prints the floors from 1 up to {@code top}, one per line, with recursion and no loop. For a {@code top} of 0 it prints nothing.
     * <p>The trick: call {@code floorsUp(top - 1)} first, so that the lower floors are printed, and only then print {@code top}. The check runs {@code floorsUp(4);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1
     * 2
     * 3
     * 4
     * }</pre>
     * Hints
     * 1. The base case is a {@code top} of 0: there's nothing to print, so the method returns.
     * 2. Otherwise, call {@code floorsUp(top - 1)} first. When it returns, floors 1 to {@code top - 1} are printed, and the method prints {@code top} after them.
     */
    public static void main(String[] args) {
        floorsUp(4);
    }

    // Write the method floorsUp here.
}
