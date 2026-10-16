// AI-Generated
package module55_recursion_ai.step04_when_recursion_goes_wrong_ai;

public class Challenge02Ai {
    /**
     * A staircase is climbed two steps at a time; when one step is left, the last move is a single step. {@code moves(steps)} should return how many moves the climb takes: 3 for 6 steps, 3 for 5 steps (2 + 2 + 1), and 0 for 0 steps or fewer. The method below works for even numbers, but an odd number jumps over its base case, and so does a negative one, and the program crashes with a StackOverflowError. Fix the base case so that every input reaches it. Keep the method recursive. The check runs:
     * <pre>{@code
     * System.out.println(moves(6));
     * System.out.println(moves(5));
     * System.out.println(moves(-4));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 3
     * 0
     * }</pre>
     * Hints
     * 1. {@code moves(5)} calls {@code moves(3)}, {@code moves(1)} and then {@code moves(-1)}, which isn't 0. Which numbers should count as "no steps left"?
     * 2. Make the base case a range: {@code if (steps <= 0)}. {@code moves(1)} then returns 1 + {@code moves(-1)}, which is 1 + 0: the last single step.
     */
    public static void main(String[] args) {
        System.out.println(moves(6));
        System.out.println(moves(5));
        System.out.println(moves(-4));
    }

    public static int moves(int steps) {
        if (steps == 0) {
            return 0;
        }
        return 1 + moves(steps - 2);
    }
}
