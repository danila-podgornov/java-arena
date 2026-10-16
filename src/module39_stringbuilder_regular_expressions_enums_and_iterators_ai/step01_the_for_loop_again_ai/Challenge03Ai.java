// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step01_the_for_loop_again_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The garden club waters its sunflowers every few days. The program reads two numbers, each on its own line: the day of the month of the first watering, and how many days apart the waterings are. With a {@code for} loop that steps with {@code +=}, print every watering day in a month of 30 days, and after them how many waterings there were. For the input {@code 3} and {@code 7} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Water on day 3
     * Water on day 10
     * Water on day 17
     * Water on day 24
     * Waterings: 4
     * }</pre>
     * Hints
     * 1. The loop variable is the day. It starts from the first watering day, goes on while it's at most 30, and grows by {@code every} in each round.
     * 2. {@code for (int day = first; day <= 30; day += every)}, with a counter that goes up in each round and is printed after the loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.valueOf(scanner.nextLine());
        int every = Integer.valueOf(scanner.nextLine());

    }
}
