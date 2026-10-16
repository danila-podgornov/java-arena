// AI-Generated
package module55_recursion_ai.step02_base_case_and_return_value_ai;

public class Challenge03Ai {
    /**
     * A sheet of paper doubles in thickness each time it's folded in half; a strip cut in three and stacked triples. Write the method {@code power(int base, int exponent)}, which returns {@code base} multiplied by itself {@code exponent} times, as a {@code long}: {@code power(2, 5)} is 2 * 2 * 2 * 2 * 2, 32. Any number to the power of 0 is 1, and that's the base case. Use recursion, no loop and no {@code Math.pow}. The exponent is never negative. The check runs:
     * <pre>{@code
     * System.out.println(power(2, 5));
     * System.out.println(power(3, 4));
     * System.out.println(power(7, 0));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 32
     * 81
     * 1
     * }</pre>
     * Hints
     * 1. {@code power(2, 5)} is 2 times {@code power(2, 4)}: the base stays the same, and the exponent gets one smaller with each call.
     * 2. When the exponent is 0, return 1. Otherwise, {@code return base * power(base, exponent - 1);}
     */
    public static void main(String[] args) {
        System.out.println(power(2, 5));
        System.out.println(power(3, 4));
        System.out.println(power(7, 0));
    }

    // Write the method power here.
}
