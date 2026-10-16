// AI-Generated
package module37_streams_and_lambdas_ai.step05_streams_of_input_ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Challenge03Ai {
    /**
     * A humidity sensor sends readings, in whole percent, one per line, until the word {@code end}. Print the different readings of 90 or more, as a list from the smallest up, each once. Read the lines into a list first, then use one stream with {@code map}, {@code filter}, {@code distinct}, {@code sorted} and {@code collect}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * {@code Humid readings: [90, 94, 97]}
     * Hints
     * 1. Read until the line is {@code end}, and add every other line to the list. Then turn the lines into numbers with {@code map(Integer::valueOf)}: sorting Strings would put {@code 100} before {@code 90}.
     * 2. After {@code map}, {@code filter(percent -> percent >= 90)}, {@code distinct()} and {@code sorted()}, and end with {@code collect(Collectors.toList())}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();

    }
}
