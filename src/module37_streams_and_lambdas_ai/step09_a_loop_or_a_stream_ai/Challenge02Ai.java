// AI-Generated
package module37_streams_and_lambdas_ai.step09_a_loop_or_a_stream_ai;

import java.util.ArrayList;
import java.util.List;

public class Challenge02Ai {
    /**
     * Some questions suit a loop better. Write the method {@code firstDayOver(List<Integer> booksSold, int target)}, which returns the number of the first day whose sales were over {@code target} (1 for the first day in the list), or 0 if no day was. Use a loop that returns as soon as it finds the day. The check runs:
     * <pre>{@code
     * List<Integer> booksSold = new ArrayList<>();
     * booksSold.add(64);
     * booksSold.add(112);
     * booksSold.add(89);
     * booksSold.add(130);
     * System.out.println(firstDayOver(booksSold, 100));
     * System.out.println(firstDayOver(booksSold, 120));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * 4
     * }</pre>
     * Hints
     * 1. The header is {@code public static int firstDayOver(List<Integer> booksSold, int target)}. The day's number is its index plus one, so go through the indexes with a {@code for} loop.
     * 2. Inside the loop, {@code if (booksSold.get(i) > target) { return i + 1; }}. After the loop, no day was over the target: {@code return 0;}.
     */
    public static void main(String[] args) {
        List<Integer> booksSold = new ArrayList<>();
        booksSold.add(64);
        booksSold.add(112);
        booksSold.add(89);
        booksSold.add(130);
        System.out.println(firstDayOver(booksSold, 100));
        System.out.println(firstDayOver(booksSold, 120));
    }

    // Write the method firstDayOver here.
}
