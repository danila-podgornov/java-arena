// AI-Generated
package module42_exceptions_ai.step01_catching_an_exception_try_and_catch_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the blanks. The program reads a temperature in degrees Celsius, a whole number, and prints it in Fahrenheit. If the line isn't a whole number, it prints {@code Not a temperature: } and the line instead. With the input {@code 21.5} it prints: see the expected output below.
     * Expected output
     * {@code Not a temperature: 21.5}
     * Hints
     * 1. The block of code that might throw starts with the word {@code try}.
     * 2. {@code Integer.parseInt} throws a {@code NumberFormatException} when the text isn't a whole number: that's the class to catch.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ___ {
            int celsius = Integer.parseInt(line);
            System.out.println(celsius + " C is " + (celsius * 9 / 5 + 32) + " F");
        } catch (___ e) {
            System.out.println("Not a temperature: " + line);
        }
    }
}
