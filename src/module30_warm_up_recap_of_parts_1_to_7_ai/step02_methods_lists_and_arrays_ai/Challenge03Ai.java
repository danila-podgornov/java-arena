// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step02_methods_lists_and_arrays_ai;

import java.util.Arrays;

public class Challenge03Ai {
    /**
     * A bakery stall lists its bread prices, in cents, in an array, in the order the loaves lie on the table. For the sign, it wants the prices sorted from the cheapest up, but the table order must stay as it is. Write the method {@code sortedCopy(int[] prices)}. It returns a new array with the same prices, sorted, and leaves the array it gets as it was. Make the new array with {@code new int[prices.length]}, copy the prices into it, and sort the copy with {@code Arrays.sort}. The check runs:
     * <pre>{@code
     * int[] prices = {850, 600, 1200, 600};
     * int[] sorted = sortedCopy(prices);
     * System.out.println(Arrays.toString(sorted));
     * System.out.println(Arrays.toString(prices));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [600, 600, 850, 1200]
     * [850, 600, 1200, 600]
     * }</pre>
     * Hints
     * 1. The method starts <code>public static int[] sortedCopy(int[] prices) {</code>. {@code int[] copy = new int[prices.length];} makes an array of the same size, full of zeros.
     * 2. Copy each price with {@code for (int i = 0; i < prices.length; i++) { copy[i] = prices[i]; }}, then {@code Arrays.sort(copy);} and {@code return copy;}. Sorting {@code prices} itself would change the caller's array.
     */
    public static void main(String[] args) {
        int[] prices = {850, 600, 1200, 600};
        int[] sorted = sortedCopy(prices);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(prices));
    }

    // Write the method sortedCopy here.
}
