// AI-Generated
package module11_return_values_and_the_call_stack_ai.step08_drawing_shapes_with_methods_ai;

public class Challenge01Ai {
    /**
     * Write {@code printDiagonal(int size)}, which prints {@code size} rows with an {@code o} in each, every row one space further to the right. Use {@code repeat} for the spaces. The check runs {@code printDiagonal(3);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * o
     *  o
     *   o
     * }</pre>
     * Hints
     * 1. Row 1 has no spaces before the {@code o}, row 2 has one, row 3 has two: row {@code r} has {@code r - 1}.
     * 2. {@code System.out.println(repeat(" ", row - 1) + "o");} inside a loop over the rows.
     */
    public static void main(String[] args) {
        printDiagonal(3);
    }

    public static String repeat(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }

    // Write the printDiagonal method here.
}
