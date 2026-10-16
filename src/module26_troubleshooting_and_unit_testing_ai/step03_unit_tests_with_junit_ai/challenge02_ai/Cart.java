// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step03_unit_tests_with_junit_ai.challenge02_ai;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Integer> prices;

    public Cart() {
        this.prices = new ArrayList<>();
    }

    public void add(int cents) {
        this.prices.add(cents);
    }

    public int itemCount() {
        return this.prices.size();
    }

    public int total() {
        int total = 0;
        for (int i = 0; i < this.prices.size(); i++) {
            total += this.prices.get(i);
        }
        return total;
    }
}
