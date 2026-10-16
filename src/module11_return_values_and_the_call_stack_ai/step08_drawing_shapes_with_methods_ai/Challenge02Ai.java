// AI-Generated
package module11_return_values_and_the_call_stack_ai.step08_drawing_shapes_with_methods_ai;

public class Challenge02Ai {
    /**
     * Write {@code printStairs(int height)}, which prints stairs rising to the right. Each step is two {@code #} wide, and each row is one step longer than the one above: row {@code r} has {@code 2 * r} symbols, pushed to the right edge with spaces. The check runs {@code printStairs(3);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     *     ##
     *   ####
     * ######
     * }</pre>
     * Hints
     * 1. Make a table like the pyramid's: for a height of 3, the spaces go 4, 2, 0 and the symbols 2, 4, 6.
     * 2. Row {@code r} has {@code 2 * (height - r)} spaces and {@code 2 * r} symbols.
     */
    public static void main(String[] args) {
        printStairs(3);
    }

    public static String repeat(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }

    // Write the printStairs method here.
}
