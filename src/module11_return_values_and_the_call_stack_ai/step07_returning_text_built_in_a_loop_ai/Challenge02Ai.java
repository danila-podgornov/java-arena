// AI-Generated
package module11_return_values_and_the_call_stack_ai.step07_returning_text_built_in_a_loop_ai;

public class Challenge02Ai {
    /**
     * Write {@code printStripes(int width, int rows)}, which prints {@code rows} lines, each {@code width} characters long. The lines take turns: {@code =} first, then {@code -}, then {@code =} again, and so on. Use the {@code repeat} method that's already there. The check runs {@code printStripes(5, 3);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * =====
     * -----
     * =====
     * }</pre>
     * Hints
     * 1. A loop over the rows. Odd rows (1, 3, 5, ...) are {@code =}, even rows are {@code -}: {@code row % 2 == 1} tells them apart.
     * 2. Each row is one line: {@code System.out.println(repeat("=", width));}
     */
    public static void main(String[] args) {
        printStripes(5, 3);
    }

    public static String repeat(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }

    // Write the printStripes method here.
}
