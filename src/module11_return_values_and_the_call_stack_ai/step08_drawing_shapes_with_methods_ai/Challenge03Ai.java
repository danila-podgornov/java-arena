// AI-Generated
package module11_return_values_and_the_call_stack_ai.step08_drawing_shapes_with_methods_ai;

public class Challenge03Ai {
    /**
     * Write {@code printDiamond(int size)}: a pyramid of {@code o} with {@code size} rows, followed by the same pyramid upside down without its widest row, so the diamond has {@code 2 * size - 1} rows. The check runs {@code printDiamond(3);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     *   o
     *  ooo
     * ooooo
     *  ooo
     *   o
     * }</pre>
     * Hints
     * 1. The top half is the pyramid from the lesson. The bottom half is the same rows again, from {@code size - 1} down to 1.
     * 2. A helper {@code printRow(int size, int row)} that prints one pyramid row keeps both loops short.
     */
    public static void main(String[] args) {
        printDiamond(3);
    }

    public static String repeat(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }

    // Write the printDiamond method here.
}
