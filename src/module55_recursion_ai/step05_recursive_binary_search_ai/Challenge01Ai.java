// AI-Generated
package module55_recursion_ai.step05_recursive_binary_search_ai;

public class Challenge01Ai {
    /**
     * A greengrocer's till has the sorted array of prices, in cents. Write the recursive method {@code findPrice(int[] prices, int price, int low, int high)}, which returns the index of {@code price} in {@code prices} between the indexes {@code low} and {@code high}, or -1 if it isn't there. Do it without a loop: binary search, as in this step. The check runs:
     * <pre>{@code
     * int[] prices = {35, 60, 99, 140, 185, 230, 299, 365, 420};
     * System.out.println(findPrice(prices, 299, 0, prices.length - 1));
     * System.out.println(findPrice(prices, 100, 0, prices.length - 1));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 6
     * -1
     * }</pre>
     * Hints
     * 1. First the empty range: when {@code low > high}, the price isn't there, so return -1. Then look at the middle, {@code (low + high) / 2}, and return its index if it holds the price.
     * 2. If the middle price is smaller, search the right half: {@code return findPrice(prices, price, middle + 1, high);}. Otherwise search the left half, from {@code low} to {@code middle - 1}.
     */
    public static void main(String[] args) {
        int[] prices = {35, 60, 99, 140, 185, 230, 299, 365, 420};
        System.out.println(findPrice(prices, 299, 0, prices.length - 1));
        System.out.println(findPrice(prices, 100, 0, prices.length - 1));
    }

    public static int findPrice(int[] prices, int price, int low, int high) {
        return -1;
    }
}
