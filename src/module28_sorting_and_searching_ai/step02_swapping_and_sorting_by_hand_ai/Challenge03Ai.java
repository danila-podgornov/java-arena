// AI-Generated
package module28_sorting_and_searching_ai.step02_swapping_and_sorting_by_hand_ai;

import java.util.Arrays;

public class Challenge03Ai {
    /**
     * A hiking trail's checkpoints are in an array, in the order of the walk out. Write the method {@code reverseInPlace(String[] checkpoints)}, which turns the same array around for the walk back: the last checkpoint becomes the first, and so on. Don't make a new array. Swap elements instead: the first with the last, the second with the second to last, and so on, up to the middle. The check runs:
     * <pre>{@code
     * String[] checkpoints = {"Parking", "Lake", "Bridge", "Summit"};
     * reverseInPlace(checkpoints);
     * System.out.println(Arrays.toString(checkpoints));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Summit, Bridge, Lake, Parking]}
     * Hints
     * 1. The element at index {@code i} trades places with the one at {@code checkpoints.length - 1 - i}. Swap them with a {@code temp} variable, which here is a String.
     * 2. Stop in the middle: {@code for (int i = 0; i < checkpoints.length / 2; i++)}. A loop over the whole array would swap every pair twice, and put everything back where it was. With an odd count, the middle element stays where it is.
     */
    public static void main(String[] args) {
        String[] checkpoints = {"Parking", "Lake", "Bridge", "Summit"};
        reverseInPlace(checkpoints);
        System.out.println(Arrays.toString(checkpoints));
    }

    // Write the method reverseInPlace here.
}
