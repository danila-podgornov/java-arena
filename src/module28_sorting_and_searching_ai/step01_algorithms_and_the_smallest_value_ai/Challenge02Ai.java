// AI-Generated
package module28_sorting_and_searching_ai.step01_algorithms_and_the_smallest_value_ai;

public class Challenge02Ai {
    /**
     * What does this program print? Two of the prices are equal, and the last line prints a price, not an index.
     * Hints
     * 1. From index 0, the lowest price is 3. It's at index 1 and again at index 3, and with {@code <} the second 3 doesn't replace the first.
     * 2. From index 2 on, the prices are 9, 3 and 5, and the 3 is at index 3 of the whole array. From index 4, only one price is left, and the last line prints the price at that index.
     */
    public static void main(String[] args) {
        int[] prices = {8, 3, 9, 3, 5};
        System.out.println(cheapestFrom(prices, 0));
        System.out.println(cheapestFrom(prices, 2));
        System.out.println(prices[cheapestFrom(prices, 4)]);
    }

    public static int cheapestFrom(int[] prices, int start) {
        int cheapest = start;
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] < prices[cheapest]) {
                cheapest = i;
            }
        }
        return cheapest;
    }
}
