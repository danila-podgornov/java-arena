// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step02_test_input_for_a_scanner_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A diary has one entry per line. Write the method {@code countEntries(Scanner scanner, String word)}: it reads lines until the input ends and returns how many of them contain the word. A line that has the word twice still counts once, and capital letters count as different letters, as they do for {@code contains}. Use the Scanner the method gets as its parameter: {@code main} gives it the keyboard, and the check gives it a String. The check runs:
     * {@code System.out.println(countEntries(new Scanner("ran 5 km\nrain all day\nran again\n"), "ran"));}
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 2}
     * Hints
     * 1. Read with {@code while (scanner.hasNextLine())}, keep each line in a variable, and count the lines for which {@code contains(word)} is true.
     * 2. {@code if (entry.contains(word)) { count++; }} inside the loop, and {@code return count;} after it. {@code rain} doesn't contain {@code ran}: the letters must come in a row.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countEntries(scanner, "ran"));
    }

    public static int countEntries(Scanner scanner, String word) {
        return 0;
    }
}
