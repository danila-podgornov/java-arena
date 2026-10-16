// AI-Generated
package module55_recursion_ai.step01_a_method_that_calls_itself_ai;

public class Challenge03Ai {
    /**
     * A bucket goes down a well, one level per call, and comes back up. {@code lower} prints a line before its recursive call and another after it. What does this program print?
     * Hints
     * 1. The lines before the recursive call come out on the way down: {@code down 1}, {@code down 2}, {@code down 3}. Then {@code lower(4)} is the base case.
     * 2. A call prints its {@code up} line only after the call it made has returned, so the deepest call's {@code up} line comes first: {@code up 3}, then {@code up 2}, then {@code up 1}.
     */
    public static void main(String[] args) {
        lower(1);
    }

    public static void lower(int level) {
        if (level > 3) {
            System.out.println("splash");
            return;
        }
        System.out.println("down " + level);
        lower(level + 1);
        System.out.println("up " + level);
    }
}
