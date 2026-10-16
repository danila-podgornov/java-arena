// AI-Generated
package module37_streams_and_lambdas_ai.step05_streams_of_input_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The station's rain gauge sends the rain of each hour, in whole millimeters, one per line, and an empty line ends them. Read the lines into a list, and then use streams to print how many hours there were, how many of them were dry (0 mm), and the total rain. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Hours: 6
     * Dry hours: 2
     * Total rain: 9 mm
     * }</pre>
     * Hints
     * 1. Read with a {@code while (true)} loop: {@code nextLine()}, {@code break} on an empty line, and {@code lines.add(line)} otherwise. The number of hours is the list's size.
     * 2. {@code lines.stream().mapToInt(Integer::valueOf).filter(mm -> mm == 0).count()} counts the dry hours, and {@code lines.stream().mapToInt(Integer::valueOf).sum()} adds up the rain.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();

    }
}
