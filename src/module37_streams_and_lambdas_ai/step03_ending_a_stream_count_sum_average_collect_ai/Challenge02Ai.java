// AI-Generated
package module37_streams_and_lambdas_ai.step03_ending_a_stream_count_sum_average_collect_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. {@code collect} makes a new list of the expenses under 50, in the old list's order. A list can make a stream of its own, so {@code cheap.stream()} works like any other.
     * 2. The cheap ones are 40, 8 and 22, which add up to 70. Only 150 is 50 or more, and {@code expenses} still has all 4.
     */
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(40);
        expenses.add(8);
        expenses.add(150);
        expenses.add(22);

        List<Integer> cheap = expenses.stream()
                .filter(amount -> amount < 50)
                .collect(Collectors.toList());
        int cheapTotal = cheap.stream()
                .mapToInt(amount -> amount)
                .sum();
        long pricey = expenses.stream()
                .filter(amount -> amount >= 50)
                .count();
        System.out.println(cheap + " " + cheapTotal);
        System.out.println(pricey + " " + expenses.size());
    }
}
