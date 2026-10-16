// AI-Generated
package module28_sorting_and_searching_ai.step04_javas_own_sorting_methods_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A pizza place logs how many minutes each delivery took. Read the times, one per line, until an empty line, into an {@code ArrayList<Integer>}. Sort the list with {@code Collections.sort} and print it. Then print the median: the middle time of the sorted list, with as many times below it as above it. The input always has an odd number of times, so the median is at index {@code size() / 2}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [19, 22, 28, 34, 41]
     * Median: 28 minutes
     * }</pre>
     * Hints
     * 1. Read in a {@code while (true)} loop that stops with {@code break} at the empty line, and add each time with {@code times.add(Integer.valueOf(line));}.
     * 2. After the loop, {@code Collections.sort(times);} sorts the list in place. With 5 times, {@code times.size() / 2} is 2, the index of the middle one: {@code times.get(times.size() / 2)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> times = new ArrayList<>();

    }
}
