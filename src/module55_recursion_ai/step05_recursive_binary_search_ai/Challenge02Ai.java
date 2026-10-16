// AI-Generated
package module55_recursion_ai.step05_recursive_binary_search_ai;

public class Challenge02Ai {
    /**
     * An auction keeps its bids in a sorted array. When a new bid comes in, where does it go? Write the recursive method {@code placeFor(int[] bids, int bid, int low, int high)}, which returns the index where {@code bid} belongs between {@code low} and {@code high}: the index of an equal bid if there is one, and otherwise the index of the first bid that's larger (or {@code high + 1} if no bid is larger). That's the binary search of this step with one change: when the range is empty, return {@code low} instead of -1. When the range is empty, {@code low} has moved past every smaller bid. The check runs:
     * <pre>{@code
     * int[] bids = {100, 150, 220, 300, 410};
     * System.out.println(placeFor(bids, 220, 0, bids.length - 1));
     * System.out.println(placeFor(bids, 200, 0, bids.length - 1));
     * System.out.println(placeFor(bids, 500, 0, bids.length - 1));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * 2
     * 5
     * }</pre>
     * Hints
     * 1. Start from {@code findPrice}. Only the empty range changes: {@code if (low > high) { return low; }}.
     * 2. Why {@code low}: the search moves {@code low} past a middle only when the middle bid is smaller than the new one, and moves {@code high} before a middle only when it's larger. When they cross, {@code low} is the first index whose bid is larger.
     */
    public static void main(String[] args) {
        int[] bids = {100, 150, 220, 300, 410};
        System.out.println(placeFor(bids, 220, 0, bids.length - 1));
        System.out.println(placeFor(bids, 200, 0, bids.length - 1));
        System.out.println(placeFor(bids, 500, 0, bids.length - 1));
    }

    // Write the method placeFor here.
}
