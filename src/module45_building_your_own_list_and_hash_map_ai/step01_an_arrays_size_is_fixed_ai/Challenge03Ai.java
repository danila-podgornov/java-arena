// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step01_an_arrays_size_is_fixed_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A solar panel reports how many watt-hours it made each day. The program reads the reports, one whole number per line, until the line {@code end}. Keep them in an {@code int} array that starts with room for 2 reports. Only when a report doesn't fit, create an array twice as long, copy the reports into it, and go on with the new array. No ArrayList.
     * <p>After {@code end}, print how many reports were read and the length of the array, as shown, and then the reports in the order they came, on one line, each followed by a space. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 5 reports in an array of length 8
     * 410 380 455 120 390
     * }</pre>
     * Hints
     * 1. Before the loop: {@code int[] reports = new int[2];} and {@code int count = 0;}. For each report, {@code reports[count] = Integer.parseInt(line);} and then {@code count++;}.
     * 2. Just before storing a report, check {@code if (count == reports.length)}: then the array is full. Create {@code int[] bigger = new int[reports.length * 2];}, copy the reports in a loop, and set {@code reports = bigger;}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
