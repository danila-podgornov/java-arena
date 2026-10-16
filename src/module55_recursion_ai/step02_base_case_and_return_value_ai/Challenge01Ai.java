// AI-Generated
package module55_recursion_ai.step02_base_case_and_return_value_ai;

public class Challenge01Ai {
    /**
     * A grocer stacks oranges in a triangle: the bottom row has {@code rows} oranges, the row above it one fewer, and so on up to a single orange at the top. Write the method {@code oranges(int rows)}, which returns how many oranges the stack has, with recursion and no loop. A stack of 0 rows has 0 oranges. The check runs:
     * <pre>{@code
     * System.out.println(oranges(4));
     * System.out.println(oranges(1));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 10
     * 1
     * }</pre>
     * Hints
     * 1. The base case: a stack of 0 rows has 0 oranges.
     * 2. A stack of {@code rows} rows is its bottom row, {@code rows} oranges, plus a stack of {@code rows - 1} rows on top: {@code return rows + oranges(rows - 1);}
     */
    public static void main(String[] args) {
        System.out.println(oranges(4));
        System.out.println(oranges(1));
    }

    public static int oranges(int rows) {
        return 0;
    }
}
