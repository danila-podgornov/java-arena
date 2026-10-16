// AI-Generated
package module11_return_values_and_the_call_stack_ai.step01_returning_a_value_ai;

public class Challenge03Ai {
    /**
     * This method should print {@code Checked!} and then return whether 10 is more than 3, but it doesn't compile. Fix it, keeping both lines. The check runs {@code System.out.println(isBigger());} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Checked!
     * true
     * }</pre>
     * Hints
     * 1. Nothing runs after a {@code return}, so the print line can never run where it is.
     * 2. Swap the two lines, so the method prints first and returns last.
     */
    public static void main(String[] args) {
        System.out.println(isBigger());
    }

    public static boolean isBigger() {
        return 10 > 3;
        System.out.println("Checked!");
    }
}
