// AI-Generated
package module15_arrays_ai.step05_arrays_and_methods_ai;

public class Challenge03Ai {
    /**
     * Write a method {@code runningTotals(int[] values)} that returns a <b>new</b> array of the same length, where each element is the sum of the values up to and including that index. The array it's given must stay as it was. The check passes the array {@code {3, 1, 4, 2}} and prints the elements of the array your method returns, one per line: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * 4
     * 8
     * 10
     * }</pre>
     * Hints
     * 1. The method starts <code>public static int[] runningTotals(int[] values) {</code> and creates {@code new int[values.length]}.
     * 2. Keep a sum in a variable. In each round, add {@code values[i]} to it and store the sum at {@code totals[i]}. Return {@code totals} at the end.
     */
    public static void main(String[] args) {
        int[] values = {3, 1, 4, 2};
        int[] totals = runningTotals(values);
        for (int total : totals) {
            System.out.println(total);
        }
    }

    // Write the runningTotals method here.
}
