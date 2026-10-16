// AI-Generated
package module28_sorting_and_searching_ai.step05_linear_search_ai;

public class Challenge01Ai {
    /**
     * In a small harbor, each berth holds one boat, and the array {@code berths} holds the boats' registration numbers, one per berth. Write the method {@code berthOf(int[] berths, int boat)}, which returns the index of the berth where the boat is, or -1 if it isn't in the harbor. The check runs:
     * <pre>{@code
     * int[] berths = {305, 118, 442, 97};
     * System.out.println(berthOf(berths, 442));
     * System.out.println(berthOf(berths, 500));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * -1
     * }</pre>
     * Hints
     * 1. It's {@code positionOf} from above with new names: go through the berths in order, and return as soon as you find the boat.
     * 2. Loop over the indexes, {@code for (int i = 0; i < berths.length; i++)}, and compare {@code berths[i]} with {@code boat}. The -1 comes after the loop, once every berth has been checked.
     */
    public static void main(String[] args) {
        int[] berths = {305, 118, 442, 97};
        System.out.println(berthOf(berths, 442));
        System.out.println(berthOf(berths, 500));
    }

    // Write the method berthOf here.
}
