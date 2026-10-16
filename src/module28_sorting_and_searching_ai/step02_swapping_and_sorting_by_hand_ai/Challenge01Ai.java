// AI-Generated
package module28_sorting_and_searching_ai.step02_swapping_and_sorting_by_hand_ai;

import java.util.Arrays;

public class Challenge01Ai {
    /**
     * What does this program print? Do the rounds on paper, the way the table does.
     * Hints
     * 1. The first round finds the smallest of all, 144 at index 4, and swaps indexes 0 and 4. The 158 that stood first moves to the end.
     * 2. Each later round looks only from its own index on. From index 1 on, the smallest is 149. From index 2 on, it's the 158 that moved to the end in the first round.
     */
    public static void main(String[] args) {
        int[] heights = {158, 162, 149, 171, 144};
        switchPlaces(heights, 0, positionOfLowest(heights, 0));
        System.out.println(Arrays.toString(heights));
        switchPlaces(heights, 1, positionOfLowest(heights, 1));
        System.out.println(Arrays.toString(heights));
        switchPlaces(heights, 2, positionOfLowest(heights, 2));
        System.out.println(Arrays.toString(heights));
    }

    public static int positionOfLowest(int[] values, int start) {
        int lowest = start;
        for (int i = start + 1; i < values.length; i++) {
            if (values[i] < values[lowest]) {
                lowest = i;
            }
        }
        return lowest;
    }

    public static void switchPlaces(int[] values, int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }
}
