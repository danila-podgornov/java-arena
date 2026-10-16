// AI-Generated
package module11_return_values_and_the_call_stack_ai.step07_returning_text_built_in_a_loop_ai;

public class Challenge03Ai {
    /**
     * Write {@code printFrame(int width, int height)}, which prints a frame of {@code #}: the top and bottom lines are full, and the lines between have a {@code #} at each end with spaces between. Width and height are always at least 2. Use {@code repeat}. The check runs {@code printFrame(5, 4);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * #####
     * #   #
     * #   #
     * #####
     * }</pre>
     * Hints
     * 1. The top and bottom lines are {@code repeat("#", width)}. The lines between them number {@code height - 2}.
     * 2. A middle line is {@code "#" + repeat(" ", width - 2) + "#"}.
     */
    public static void main(String[] args) {
        printFrame(5, 4);
    }

    public static String repeat(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }

    // Write the printFrame method here.
}
