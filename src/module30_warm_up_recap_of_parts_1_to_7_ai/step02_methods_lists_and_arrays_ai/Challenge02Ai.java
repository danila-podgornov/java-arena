// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step02_methods_lists_and_arrays_ai;

import java.util.ArrayList;
import java.util.Collections;

public class Challenge02Ai {
    /**
     * A stall's prices are in cents, and {@code cheapest} gives back the cheapest ones. What does this program print? Watch what happens to the list that {@code main} hands the method.
     * Hints
     * 1. {@code cheapest} sorts its parameter, and then copies the first {@code count} prices into a new list. The new list holds the two cheapest prices.
     * 2. The parameter {@code prices} is the same list as {@code main}'s {@code prices}, not a copy, so {@code main} sees it sorted too. The last line adds up the sizes of the two lists.
     */
    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(450);
        prices.add(200);
        prices.add(325);
        ArrayList<Integer> cheap = cheapest(prices, 2);
        System.out.println(cheap);
        System.out.println(prices);
        System.out.println(cheap.size() + prices.size());
    }

    public static ArrayList<Integer> cheapest(ArrayList<Integer> prices, int count) {
        Collections.sort(prices);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(prices.get(i));
        }
        return result;
    }
}
