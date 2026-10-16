// AI-Generated
package module28_sorting_and_searching_ai.step03_selection_sort_in_code_ai;

import java.util.Arrays;

public class Challenge01Ai {
    /**
     * A depot weighs its parcels, in kilograms. Fill in the blanks of {@code sortWeights}, so that it sorts the array from the lightest parcel to the heaviest with selection sort. {@code positionOfLowest} and {@code switchPlaces} are the methods from above. The check runs:
     * <pre>{@code
     * int[] weights = {12, 4, 9, 1, 7};
     * sortWeights(weights);
     * System.out.println(Arrays.toString(weights));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [1, 4, 7, 9, 12]}
     * Hints
     * 1. There's a round for every index but the last, and each round looks for the lightest parcel from the round's own index on.
     * 2. {@code positionOfLowest(weights, i)} gives the index of the lightest parcel from index {@code i} on, and the swap moves that parcel to index {@code i}: {@code switchPlaces(weights, i, lightest)}.
     */
    public static void main(String[] args) {
        int[] weights = {12, 4, 9, 1, 7};
        sortWeights(weights);
        System.out.println(Arrays.toString(weights));
    }

    public static void sortWeights(int[] weights) {
        for (int i = 0; i < ___; i++) {
            int lightest = positionOfLowest(weights, ___);
            switchPlaces(weights, i, ___);
        }
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
