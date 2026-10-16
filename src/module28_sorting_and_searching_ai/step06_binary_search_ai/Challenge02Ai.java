// AI-Generated
package module28_sorting_and_searching_ai.step06_binary_search_ai;

public class Challenge02Ai {
    /**
     * This binary search prints each value it looks at. What does the program print?
     * Hints
     * 1. The first middle is {@code (0 + 6) / 2}, index 3, which holds 12. For 23, the search goes on to the right: {@code low} becomes 4, and the next middle is {@code (4 + 6) / 2}, index 5.
     * 2. The method prints its lines before {@code main} prints the index it returns. For 3, the range shrinks toward the start of the array, and is empty after three looks, so {@code main} prints -1.
     */
    public static void main(String[] args) {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38};
        System.out.println(find(sorted, 23));
        System.out.println(find(sorted, 3));
    }

    public static int find(int[] sorted, int wanted) {
        int low = 0;
        int high = sorted.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            System.out.println("looking at " + sorted[middle]);
            if (sorted[middle] == wanted) {
                return middle;
            }
            if (sorted[middle] < wanted) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
