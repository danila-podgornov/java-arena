// AI-Generated
package module16_working_with_strings_ai.step06_data_in_a_fixed_format_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A training app saves lines such as {@code running,35}: an activity and how many minutes it took. Fill in the blanks, so the program reads one such line and prints the activity and its length in minutes and in seconds. For the input {@code running,35} it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * running for 35 minutes
     * That's 2100 seconds
     * }</pre>
     * Hints
     * 1. The separator goes between the quotes of {@code split}. In {@code running,35} it's the comma.
     * 2. Text becomes an {@code int} with {@code Integer.valueOf(...)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split("___");
        String activity = parts[0];
        int minutes = Integer.___(parts[1]);
        System.out.println(activity + " for " + minutes + " minutes");
        System.out.println("That's " + (minutes * 60) + " seconds");
    }
}
