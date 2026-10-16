// AI-Generated
package module37_streams_and_lambdas_ai.step04_steps_in_the_middle_map_sorted_distinct_limit_skip_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. Follow each chain a step at a time. {@code distinct()} keeps the first copy of each value, {@code skip(1)} drops the first value that reaches it, and {@code limit} lets only the first ones through. In the second chain, {@code sorted()} comes after the division, and dividing {@code int} values drops the remainder.
     * 2. {@code distinct()} leaves 90, 40, 150 and 75, which sort to 40, 75, 90 and 150, so {@code skip(1)} drops 40 and {@code limit(2)} keeps 75 and 90. The second chain starts again from the whole list. {@code limit(3)} keeps 90, 40 and 150, dividing by 10 gives 9, 4 and 15, and only then are they sorted.
     */
    public static void main(String[] args) {
        ArrayList<Integer> tickets = new ArrayList<>();
        tickets.add(90);
        tickets.add(40);
        tickets.add(150);
        tickets.add(40);
        tickets.add(75);

        tickets.stream()
                .distinct()
                .sorted()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        tickets.stream()
                .limit(3)
                .map(sold -> sold / 10)
                .sorted()
                .forEach(System.out::println);
    }
}
