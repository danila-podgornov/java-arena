// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step02_test_input_for_a_scanner_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * {@code countLong} should count the words that have at least 5 letters, and {@code main} checks it with four inputs. But the method has a bug. What does the program print?
     * Hints
     * 1. {@code > 5} counts only words of 6 letters or more, so a word of exactly 5 letters is missed. Go through each check's words and count what the method really counts.
     * 2. In the first check only {@code banana} is counted, so it's 1 instead of 2. {@code kiwi} and the empty input give 0 as they should. {@code melon} and {@code lemon} both have exactly 5 letters, so neither is counted.
     */
    public static void main(String[] args) {
        check("apple\nfig\nbanana\n", 2);
        check("kiwi\n", 0);
        check("", 0);
        check("melon\nlemon\n", 2);
    }

    public static void check(String input, int expected) {
        int result = countLong(new Scanner(input));
        if (result == expected) {
            System.out.println("ok");
        } else {
            System.out.println("WRONG: expected " + expected + " but got " + result);
        }
    }

    public static int countLong(Scanner scanner) {
        int count = 0;
        while (scanner.hasNextLine()) {
            if (scanner.nextLine().length() > 5) {
                count++;
            }
        }
        return count;
    }
}
