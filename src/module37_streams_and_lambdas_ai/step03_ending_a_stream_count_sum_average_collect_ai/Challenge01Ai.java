// AI-Generated
package module37_streams_and_lambdas_ai.step03_ending_a_stream_count_sum_average_collect_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * Fill in the blanks so that the program prints the month's total and the average expense. The average is the stream's own {@code average()}, which divides the sum by the count. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Total: 240
     * Average: 48.0
     * }</pre>
     * Hints
     * 1. A stream of Integers has no {@code sum} or {@code average}: it needs a step that turns it into a stream of {@code int} values first. And {@code average()} gives a box, not the double itself.
     * 2. The step that turns the Integers into {@code int} values is {@code mapToInt}. {@code average()} returns an OptionalDouble, and the method that takes the double out of it is {@code getAsDouble()}.
     */
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<>();
        expenses.add(72);
        expenses.add(15);
        expenses.add(98);
        expenses.add(31);
        expenses.add(24);

        int total = expenses.stream()
                .___(amount -> amount)
                .sum();
        double average = expenses.stream()
                .___(amount -> amount)
                .average()
                .___();
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
    }
}
