// AI-Generated
package module28_sorting_and_searching_ai.step03_selection_sort_in_code_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * Here is the one-method version, with a print at the end of each round. What does it print?
     * Hints
     * 1. The first round finds the smallest value, 1, at index 1, and swaps it with the 5 at index 0. The inner loop of the next round starts from index 2, and so on.
     * 2. The array can be sorted before the last round, but the loop doesn't check for that. There are always {@code numbers.length - 1} rounds, and each one prints.
     */
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2};
        for (int i = 0; i < numbers.length - 1; i++) {
            int lowest = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[lowest]) {
                    lowest = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[lowest];
            numbers[lowest] = temp;
            System.out.println(Arrays.toString(numbers));
        }
    }
}
