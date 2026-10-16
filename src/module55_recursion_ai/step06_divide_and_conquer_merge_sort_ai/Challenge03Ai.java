// AI-Generated
package module55_recursion_ai.step06_divide_and_conquer_merge_sort_ai;

import java.util.Arrays;

public class Challenge03Ai {
    /**
     * A crossword maker lists candidate words and wants them sorted by length, shortest first. Words of the same length must stay in the order they were given in: the sort must be stable. Write {@code sortByLength(String[] words)}, which returns a new array sorted that way, with merge sort. You need your own merge for Strings, {@code mergeByLength(String[] first, String[] second)}, which compares the words' lengths, and takes from {@code first} when two lengths are equal. {@code Arrays.copyOfRange} works for String arrays too. Don't use {@code Arrays.sort} or {@code Collections.sort}. The check runs:
     * <pre>{@code
     * String[] words = {"orbit", "fig", "ash", "lantern", "elm", "pearl"};
     * System.out.println(Arrays.toString(sortByLength(words)));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [fig, ash, elm, orbit, pearl, lantern]}
     * Hints
     * 1. {@code sortByLength} is the {@code mergeSort} of the last challenge with {@code String[]} in place of {@code int[]}, calling {@code mergeByLength}.
     * 2. {@code mergeByLength} is {@code merge} with Strings, comparing {@code first[i].length() <= second[j].length()}. The {@code <=} takes the word from {@code first} when the lengths are equal, which keeps the sort stable: {@code first} holds the words that came earlier.
     */
    public static void main(String[] args) {
        String[] words = {"orbit", "fig", "ash", "lantern", "elm", "pearl"};
        System.out.println(Arrays.toString(sortByLength(words)));
    }

    public static String[] sortByLength(String[] words) {
        return words;
    }

    // Write the method mergeByLength here.
}
