// AI-Generated
package module55_recursion_ai.step06_divide_and_conquer_merge_sort_ai;

import java.util.Arrays;

public class Challenge01Ai {
    /**
     * Two park rangers measured trees, and each wrote the heights, in meters, in a sorted array. Write the method {@code merge(int[] first, int[] second)}, which returns a new array of all the heights of both, sorted, as in this step. Don't sort the result with {@code Arrays.sort}: merge. The check runs:
     * <pre>{@code
     * int[] north = {4, 9, 17, 22};
     * int[] south = {6, 9, 30};
     * System.out.println(Arrays.toString(merge(north, south)));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [4, 6, 9, 9, 17, 22, 30]}
     * Hints
     * 1. Keep a place in each array, {@code i} in {@code first} and {@code j} in {@code second}, and one in {@code merged}, {@code k}. While both arrays have values left, copy the smaller of {@code first[i]} and {@code second[j]} and move that array's place on.
     * 2. When one array runs out, copy the rest of the other one, with a loop for each array (only one of the two has anything left).
     */
    public static void main(String[] args) {
        int[] north = {4, 9, 17, 22};
        int[] south = {6, 9, 30};
        System.out.println(Arrays.toString(merge(north, south)));
    }

    public static int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        return merged;
    }
}
