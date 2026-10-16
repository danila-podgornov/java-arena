// AI-Generated
package module28_sorting_and_searching_ai.step06_binary_search_ai;

public class Challenge03Ai {
    /**
     * How many values does binary search look at? Write the method {@code looksNeeded(int[] sorted, int wanted)}. It does the binary search of this step, with the middle at {@code (low + high) / 2}, but instead of an index it returns how many middle values it looked at, whether it found the wanted value or not.
     * <p>The check makes a sorted array of the 1,000 even numbers from 0 to 1998, and looks for 998, 1998 and 7. A linear search would look at 500, 1,000 and 1,000 values for them. (998 happens to sit right in the middle of the array.) The check runs:
     * <pre>{@code
     * int[] evens = new int[1000];
     * for (int i = 0; i < evens.length; i++) {
     *     evens[i] = i * 2;
     * }
     * System.out.println(looksNeeded(evens, 998));
     * System.out.println(looksNeeded(evens, 1998));
     * System.out.println(looksNeeded(evens, 7));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1
     * 10
     * 10
     * }</pre>
     * Hints
     * 1. Start from the binary search of this step, and add a counter, {@code int looks = 0;}. Each round of the loop looks at one middle value, so it adds one to {@code looks}.
     * 2. Return {@code looks} where the search would return {@code middle}, and also after the loop, where it would return -1.
     */
    public static void main(String[] args) {
        int[] evens = new int[1000];
        for (int i = 0; i < evens.length; i++) {
            evens[i] = i * 2;
        }
        System.out.println(looksNeeded(evens, 998));
        System.out.println(looksNeeded(evens, 1998));
        System.out.println(looksNeeded(evens, 7));
    }

    // Write the method looksNeeded here.
}
