// AI-Generated
package module28_sorting_and_searching_ai.step06_binary_search_ai;

public class Challenge01Ai {
    /**
     * A mail carrier has a sorted array of the house numbers that get mail today. Fill in the blanks of {@code findHouse}, a binary search that returns the index of a house number, or -1 if the house gets no mail. The check runs:
     * <pre>{@code
     * int[] houses = {2, 4, 8, 10, 14, 16, 20, 22, 26};
     * System.out.println(findHouse(houses, 20));
     * System.out.println(findHouse(houses, 12));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 6
     * -1
     * }</pre>
     * Hints
     * 1. The middle of the range from {@code low} to {@code high} is their sum divided by two: {@code (low + high) / 2}.
     * 2. When the middle house number is smaller than the wanted one, the wanted one can only be to the right of the middle, so the range starts after it: {@code middle + 1}. Otherwise it ends before it: {@code middle - 1}.
     */
    public static void main(String[] args) {
        int[] houses = {2, 4, 8, 10, 14, 16, 20, 22, 26};
        System.out.println(findHouse(houses, 20));
        System.out.println(findHouse(houses, 12));
    }

    public static int findHouse(int[] houses, int number) {
        int low = 0;
        int high = houses.length - 1;
        while (low <= high) {
            int middle = ___;
            if (houses[middle] == number) {
                return middle;
            }
            if (houses[middle] < number) {
                low = ___;
            } else {
                high = ___;
            }
        }
        return -1;
    }
}
