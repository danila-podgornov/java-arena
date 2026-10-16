// AI-Generated
package module11_return_values_and_the_call_stack_ai.step06_the_call_stack_ai;

public class Challenge03Ai {
    /**
     * What does this program print? A value is returned through two calls.
     * Hints
     * 1. {@code outer(3)} calls {@code inner(4)}, which prints first and returns 40.
     * 2. Then {@code outer} prints what it got and returns 80 to {@code main}.
     */
    public static void main(String[] args) {
        int result = outer(3);
        System.out.println("Result: " + result);
    }

    public static int outer(int n) {
        int value = inner(n + 1);
        System.out.println("outer got " + value);
        return value * 2;
    }

    public static int inner(int n) {
        System.out.println("inner got " + n);
        return n * 10;
    }
}
