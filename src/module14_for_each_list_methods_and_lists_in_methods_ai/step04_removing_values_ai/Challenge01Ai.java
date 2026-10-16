// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step04_removing_values_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The program reads prices until {@code 0}, and should remove every price above 50 from the list. It crashes, because it removes inside a for-each loop. Rewrite the removing loop as an index loop that goes backwards. For the input 20, 75, 35, 60, 90 and 10 it prints: see the expected output below.
     * Expected output
     * {@code Within budget: [20, 35, 10]}
     * Hints
     * 1. Start at the last index and count down: {@code for (int i = prices.size() - 1; i >= 0; i--)}.
     * 2. Inside, check {@code prices.get(i) > 50} and remove with {@code prices.remove(i);}. Here {@code i} is an index, which is just what you want.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> prices = new ArrayList<>();
        while (true) {
            int price = Integer.valueOf(scanner.nextLine());
            if (price == 0) {
                break;
            }
            prices.add(price);
        }

        for (int price : prices) {
            if (price > 50) {
                prices.remove(Integer.valueOf(price));
            }
        }
        System.out.println("Within budget: " + prices);
    }
}
