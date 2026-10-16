// AI-Generated
package module20_reading_files_ai.step08_records_in_a_file_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * What does this program print? Every line is split, and then each of its parts is added.
     * Hints
     * 1. The String holds three lines: {@code 7,8}, {@code 10,5,1} and {@code 4}.
     * 2. A line without a comma splits into one part: the whole line.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner("7,8\n10,5,1\n4");
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            int sum = 0;
            for (String part : parts) {
                sum += Integer.valueOf(part);
            }
            System.out.println("Parts: " + parts.length + ", sum: " + sum);
        }
    }
}
